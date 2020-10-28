#include <arpa/inet.h>
#include <openssl/err.h>
#include <openssl/evp.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/prctl.h>
#include <sys/ptrace.h>
#include <sys/random.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <sys/un.h>
#include <sys/wait.h>
#include <unistd.h>

#define DEBUG
#ifdef DEBUG
#define DEBUG_PRINT(fmt, ...) \
            do {fprintf(logger, fmt, __VA_ARGS__);fflush(logger);} while (0)
#else
#define DEBUG_PRINT(fmt, ...)
#endif

#define DEFAULT_STACKS 8
#define EVP_ERR                  \
  {                              \
    ERR_print_errors_fp(logger); \
  }
FILE* logger;

const char* op_as_string(enum Ops op)
{
  switch(op)
  {
    case STACK:
      return "STACK";
    case PUSH:
      return "PUSH";
    case PUSH2:
      return "PUSH2";
    case POP:
      return "POP";
    case POP2:
      return "POP2";
    case DUP:
      return "DUP";
    case DUP2:
      return "DUP2";
    case FRONT:
      return "FRONT";
    case DUPX1:
      return "DUPX1";
    case DUPX2:
      return "DUPX2";
    case DUP2X1:
      return "DUP2X1";
    case DUP2X2:
      return "DUP2X2";
    case SWAP:
      return "SWAP";
    case KILL:
      return "KILL";
    case CLR:
      return "CLEAR";
    case ACK:
      return "ACK";
    default:
      return "UNK";
  }
}

static inline int encrypt_aes256(unsigned char* plaintext, int plainlen,
                                 unsigned char key[32], unsigned char mask[32],
                                 unsigned char* ciphertext)
{
  EVP_CIPHER_CTX* ctx = EVP_CIPHER_CTX_new();
  unsigned char unmasked_key[32];
  for(int i = 0; i < 32; i++)
  {
    unmasked_key[i] = mask[i] ^ key[i];
  }
  int cipherlen;
  int len;
  if(!ctx)
    EVP_ERR;
  if(!EVP_EncryptInit_ex(ctx, EVP_aes_256_ecb(), NULL, unmasked_key, NULL))
    EVP_ERR;
  EVP_CIPHER_CTX_set_padding(ctx, 0);
  if(!EVP_EncryptUpdate(ctx, ciphertext, &cipherlen, plaintext, plainlen))
    EVP_ERR;
  if(!EVP_EncryptFinal_ex(ctx, ciphertext + cipherlen, &len))
    EVP_ERR;
  EVP_CIPHER_CTX_free(ctx);
  return cipherlen + len;
}

static inline int decrypt_aes256(unsigned char* ciphertext, int cipherlen,
                                 unsigned char key[32], unsigned char mask[32],
                                 unsigned char* plaintext)
{
  EVP_CIPHER_CTX* ctx = EVP_CIPHER_CTX_new();
  EVP_CIPHER_CTX_set_padding(ctx, 0);
  unsigned char unmasked_key[32];
  for(int i = 0; i < 32; i++)
  {
    unmasked_key[i] = mask[i] ^ key[i];
  }
  int plainlen;
  int len;
  if(!ctx)
    EVP_ERR;
  if(!EVP_DecryptInit_ex(ctx, EVP_aes_256_ecb(), NULL, unmasked_key, NULL))
    EVP_ERR;
  EVP_CIPHER_CTX_set_padding(ctx, 0);
  if(!EVP_DecryptUpdate(ctx, plaintext, &plainlen, ciphertext, cipherlen))
    EVP_ERR;
  if(!EVP_DecryptFinal_ex(ctx, plaintext + plainlen, &len))
    EVP_ERR;
  EVP_CIPHER_CTX_free(ctx);
  return plainlen + len;
}

static inline void get_key(uint8_t* opcode_key, uint64_t* data_key)
{
  uint64_t opcode_key_full = next_rng();
  *opcode_key = ((uint8_t*)(&opcode_key_full))[0];
  *data_key = next_rng();
}

static inline enum Ops fetch_command(int fd, void** data)
{
  // get parent key
  uint64_t data_key;
  uint8_t opcode_key;
  get_key(&opcode_key, &data_key);
  // retrieve data
  uint8_t buf[sizeof(void*) + 1];
  recv(fd, buf, sizeof(void*) + 1, 0);
  memcpy(data, buf + 1, sizeof(void*));
  uint8_t cmd = buf[0];
  // decrypt it
  uint64_t data_enc = *data;
  data_enc ^= data_key;
  *data = data_enc;
  cmd ^= opcode_key;
  DEBUG_PRINT("Command: [%s][%lu]\n", op_as_string(cmd), *data);
  DEBUG_PRINT("The parent key was 0x%02X%016lX\n", opcode_key, data_key);
  return cmd;
}

static inline void send_result(int fd, void* data)
{
  uint64_t data_key;
  uint8_t opcode_key;
  get_key(&opcode_key, &data_key);
  uint8_t buf[sizeof(void*) + 1];
  DEBUG_PRINT("Answer: [%s][%lu]\n", op_as_string(ACK), data);
  DEBUG_PRINT("My key is 0x%02X%016lX\n", opcode_key, data_key);
  data = (uint64_t)data ^ data_key;
  // FIXME: possible leak: this ACK is constant, may leak information about the
  // prng
  buf[0] = ACK ^ opcode_key;
  memcpy(buf + 1, &data, sizeof(void*));
  send(fd, buf, sizeof(void*) + 1, 0);
}

int main(int argc, const char* argv[])
{
  struct sockaddr_un addr;
  char socket_path[34] = {0};
  int fd;
  // TODO: remove \0 at beginning for non-linux kernels
  strncpy(socket_path + 1, argv[1], 32);
  if((fd = socket(AF_UNIX, SOCK_STREAM, 0)) == -1)
    exit(0);
  int sync;
  memset(&addr, 0, sizeof(addr));
  addr.sun_family = AF_UNIX;
  *addr.sun_path = '\0';
  strncpy(addr.sun_path + 1, socket_path + 1, sizeof(addr.sun_path) - 2);
  while(connect(fd, (struct sockaddr*)&addr, sizeof(addr)) == -1)
    ;
  uint32_t mypid_h = getpid();
  uint32_t mypid_n = htonl(mypid_h);
  uint32_t parent_pid_h;
  uint32_t parent_pid_n;
  char log_filename[32];
  snprintf(log_filename, 32, "/tmp/log_child_%d.txt", mypid_h);
  logger = fopen(log_filename, "w");
  if(send(fd, &mypid_n, sizeof(uint32_t), 0) == -1)
    exit(0);
  if(recv(fd, &parent_pid_n, sizeof(uint32_t), 0) == -1)
    exit(0);
  parent_pid_h = ntohl(parent_pid_n);
  // start antidebug operations
  enum Ops command = !KILL;
  void* data = 0x0;

  // each stack is an instance of a JVM (like a call to a method. Each recursive
  // call needs a new stack) only recursive calls and not async ones! Stacks are
  // expected to die in order!
  size_t cur_stack = -1;
  size_t stacks_allocs = DEFAULT_STACKS;
  // void* -> type. ** -> stack *** -> array of stacks
  void*** stacks = (void***)malloc(sizeof(void**) * stacks_allocs);
  // each stack needs an index
  size_t* stacks_indices = (size_t*)malloc(sizeof(size_t) * stacks_allocs);
  // filled by parent with a POKEDATA call
  volatile uint8_t parent_random[32];
  // filled by me, data passed to parent with a POKEDATA into ot_mem_addr
  uint8_t child_random[32];
  // memory address of parent_random in my process
  void* my_mem_addr = (void*)parent_random;
  // memory address of the child_random in the other process
  void* ot_mem_addr;
  void* sink;
  uint64_t small_buf = 0;
  recv(fd, &ot_mem_addr, sizeof(void*), 0);
  if(prctl(PR_SET_PTRACER, parent_pid_h) == -1)
  {
    DEBUG_PRINT("%s\n", "prctl failure");
    exit(0);
  }
  DEBUG_PRINT("My address is 0x%016lX, Other address is 0x%016lX\n",
          my_mem_addr, ot_mem_addr);
  send(fd, &my_mem_addr, sizeof(void*), 0);
  if(ptrace(PTRACE_ATTACH, parent_pid_h, NULL, NULL) != -1)
  {
    DEBUG_PRINT("%s\n", "Ptraced");
    int status;
    waitpid(parent_pid_h, &status, 0);
    // generates the random seed
    getrandom(&child_random, sizeof(child_random), 0);
    DEBUG_PRINT("Generated data 0x%016lX 0x%016lX\n",
            ((uint64_t*)child_random)[0], ((uint64_t*)child_random)[1]);
    if(WIFSTOPPED(status))
    {
      uint8_t plain[32];
      memcpy(plain, child_random, sizeof(child_random));
      ((uint64_t*)plain)[0] += parent_pid_h;
      ((uint64_t*)plain)[1] += mypid_h;
      uint8_t encrypted[32];
      encrypt_aes256(plain, sizeof(plain), auth_key, mask_key, encrypted);
      for(int i = 0; i < 4; i++)
      {
        void* data = (void*)(((uint64_t*)encrypted)[i]);
        if(ptrace(PTRACE_POKEDATA, parent_pid_h,
                  ot_mem_addr + (i * sizeof(void*)), data) == -1)
        {
          DEBUG_PRINT("%s\n","Poke Failed");
        }
        else
        {
          DEBUG_PRINT("Poked %d/4\n", i + 1);
        }
      }
    }
    else
    {
      DEBUG_PRINT("%s\n", "Poke not even tried");
    }
    fflush(logger);
    ptrace(PTRACE_CONT, parent_pid_h, NULL, NULL);
  }
  else
  {
    DEBUG_PRINT("%s\n", "Ptrace failed, generating random seed\n");
    // generates the random seed
    getrandom(&child_random, sizeof(child_random), 0);
  }
  // let the parent continue with the debugging
  send(fd, &sink, sizeof(void*), 0);
  // now wait for him
  recv(fd, &sink, sizeof(void*), 0);
  uint8_t decrypted[32];
  decrypt_aes256(parent_random, 32, auth_key, mask_key, decrypted);
  DEBUG_PRINT("Encrypted was 0x%016lX 0x%016lX. ",
          ((uint64_t*)parent_random)[0], ((uint64_t*)parent_random)[1]);
  DEBUG_PRINT("Decrypted is 0x%016lX 0x%016lX.\n",
          ((uint64_t*)decrypted)[0], ((uint64_t*)decrypted)[1]);
  long_jump = decrypted[20];
  short_jump = child_random[20];
  prng_state[0] = ((uint64_t*)decrypted)[0] - parent_pid_h;
  prng_state[1] = ((uint64_t*)decrypted)[1] - mypid_h;
  prng_state[2] = ((uint64_t*)child_random)[0];
  prng_state[3] = ((uint64_t*)child_random)[1];
  DEBUG_PRINT("Seed is 0x%016lX 0x%016lX 0x%016lX 0x%016lX\n",
          prng_state[0], prng_state[1], prng_state[2], prng_state[3]);
  DEBUG_PRINT("Long jump is 0x%02X, Short jump is 0x%02X\n", long_jump,
          short_jump);

  while(command != KILL || cur_stack != -1)
  {
    command = fetch_command(fd, &data);
    switch(command)
    {
      case STACK:
        cur_stack++;
        if(cur_stack == stacks_allocs)
        {
          DEBUG_PRINT("Requested %d stacks but %d are allocated. Realloc.\n",
                  cur_stack + 1, stacks_allocs);
          stacks_allocs <<= 1;
          stacks = realloc(stacks, sizeof(void**) * stacks_allocs);
          stacks_indices =
              realloc(stacks_indices, sizeof(size_t) * stacks_allocs);
          DEBUG_PRINT("Allocated %d stacks\n", stacks_allocs);
        }
        uint64_t stack_len;
        memcpy(&stack_len, &data, sizeof(void*));
        stacks[cur_stack] = (void**)malloc(sizeof(void*) * stack_len);
        stacks_indices[cur_stack] = 0;
        data = cur_stack;
        break;
      case PUSH:
      {
        stacks[cur_stack][stacks_indices[cur_stack]++] = data;
        data = 0x0;
        break;
      }
      case PUSH2:
      {
        stacks[cur_stack][stacks_indices[cur_stack]++] = data;
        stacks_indices[cur_stack]++;
        data = 0x0;
        break;
      }
      case POP:
      {
        data = stacks[cur_stack][--stacks_indices[cur_stack]];
        break;
      }
      case POP2:
      {
        stacks_indices[cur_stack]--;
        data = stacks[cur_stack][--stacks_indices[cur_stack]];
        break;
      }
      case DUP:
      {
        data = 0x0;
        stacks[cur_stack][stacks_indices[cur_stack]] =
            stacks[cur_stack][stacks_indices[cur_stack] - 1];
        stacks_indices[cur_stack]++;
        break;
      }
      case DUP2:
      {
        data = 0x0;
        stacks[cur_stack][stacks_indices[cur_stack]] =
            stacks[cur_stack][stacks_indices[cur_stack] - 2];
        stacks[cur_stack][stacks_indices[cur_stack] + 1] =
            stacks[cur_stack][stacks_indices[cur_stack] - 1];
        stacks_indices[cur_stack]++;
        stacks_indices[cur_stack]++;
        break;
      }
      case FRONT:
      {
        data = stacks[cur_stack][stacks_indices[cur_stack] - 1];
        break;
      }
      case DUPX1:
      {
        data = 0x0;
        void* dup0 = stacks[cur_stack][--stacks_indices[cur_stack]];
        void* mid0 = stacks[cur_stack][--stacks_indices[cur_stack]];
        stacks[cur_stack][stacks_indices[cur_stack]++] = dup0;
        stacks[cur_stack][stacks_indices[cur_stack]++] = mid0;
        stacks[cur_stack][stacks_indices[cur_stack]++] = dup0;
        break;
      }
      case DUPX2:
      {
        data = 0x0;
        void* dup0 = stacks[cur_stack][--stacks_indices[cur_stack]];
        void* mid1 = stacks[cur_stack][--stacks_indices[cur_stack]];
        void* mid0 = stacks[cur_stack][--stacks_indices[cur_stack]];
        stacks[cur_stack][stacks_indices[cur_stack]++] = dup0;
        stacks[cur_stack][stacks_indices[cur_stack]++] = mid0;
        stacks[cur_stack][stacks_indices[cur_stack]++] = mid1;
        stacks[cur_stack][stacks_indices[cur_stack]++] = dup0;
        break;
      }
      case DUP2X1:
      {
        data = 0x0;
        void* dup1 = stacks[cur_stack][--stacks_indices[cur_stack]];
        void* dup0 = stacks[cur_stack][--stacks_indices[cur_stack]];
        void* mid0 = stacks[cur_stack][--stacks_indices[cur_stack]];
        stacks[cur_stack][stacks_indices[cur_stack]++] = dup0;
        stacks[cur_stack][stacks_indices[cur_stack]++] = dup1;
        stacks[cur_stack][stacks_indices[cur_stack]++] = mid0;
        stacks[cur_stack][stacks_indices[cur_stack]++] = dup0;
        stacks[cur_stack][stacks_indices[cur_stack]++] = dup1;
        break;
      }
      case DUP2X2:
      {
        data = 0x0;
        void* dup1 = stacks[cur_stack][--stacks_indices[cur_stack]];
        void* dup0 = stacks[cur_stack][--stacks_indices[cur_stack]];
        void* mid1 = stacks[cur_stack][--stacks_indices[cur_stack]];
        void* mid0 = stacks[cur_stack][--stacks_indices[cur_stack]];
        stacks[cur_stack][stacks_indices[cur_stack]++] = dup0;
        stacks[cur_stack][stacks_indices[cur_stack]++] = dup1;
        stacks[cur_stack][stacks_indices[cur_stack]++] = mid0;
        stacks[cur_stack][stacks_indices[cur_stack]++] = mid1;
        stacks[cur_stack][stacks_indices[cur_stack]++] = dup0;
        stacks[cur_stack][stacks_indices[cur_stack]++] = dup1;
        break;
      }
      case SWAP:
      {
        data = 0x0;
        void* tmp = stacks[cur_stack][stacks_indices[cur_stack] - 2];
        stacks[cur_stack][stacks_indices[cur_stack] - 2] =
            stacks[cur_stack][stacks_indices[cur_stack] - 1];
        stacks[cur_stack][stacks_indices[cur_stack] - 1] = tmp;
        break;
      }
      case CLR:
      {
        data = 0x0;
        stacks_indices[cur_stack] = 0;
        break;
      }
      case KILL:
        free(stacks[cur_stack]);
        data = cur_stack;
        cur_stack--;
        break;
      case ACK:
        data = 0x0;
        break;
      default: // unrecognized command, send normal answer, but reseeds prng so
               // all the next answers will be wrong
        getrandom(&prng_state[0], sizeof(uint64_t), 0);
        getrandom(&prng_state[1], sizeof(uint64_t), 0);
        getrandom(&prng_state[2], sizeof(uint64_t), 0);
        getrandom(&prng_state[3], sizeof(uint64_t), 0);
        exit(0);
    }
    send_result(fd, data);
  }
  fclose(logger);
  free(stacks_indices);
  free(stacks);
  return 0;
}
