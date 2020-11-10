#include <openssl/err.h>
#include <openssl/evp.h>
#include <sys/mman.h> //To change the protection of invoked libraries (and fuck up the java debugging library)
#include <sys/prctl.h> // Here starts the includes for the AntidebugSelf Technique
#include <sys/ptrace.h>
#include <sys/random.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <sys/un.h>
#include <sys/wait.h> // Here ends the includes for the AntidebugSelf Technique
#include <time.h> //required by the AntidebugTime and some performance test. Not a big deal if it is unnecessary

#define DEBUG
#ifdef DEBUG
#define DEBUG_PRINT(fmt, ...) \
            do {printf(fmt, __VA_ARGS__);fflush(stdout);} while (0)
#else
#define DEBUG_PRINT(fmt, ...)
#endif

#define EVP_ERR                  \
  {                              \
    ERR_print_errors_fp(stdout); \
  }

static inline void time_start(time_t* start)
{
  time(start);
}

static inline void time_check(time_t* start)
{
  if(difftime(time(NULL), *start) > 0)
  {
    exit(EXIT_SUCCESS);
  }
}

#define SOCKET_NAME_LEN 32
static inline void gen_socket_name(char* buffer)
{
  srand(time(NULL));
  const char charset[] =
      "qwertyuiopasdgfhljkzxcnbvmQWERTYUIOPASDGFHJKLZXCVNBM1324567890";
  for(int i = 0; i < SOCKET_NAME_LEN; i++)
  {
    int key = rand() % (int)(sizeof(charset) - 1);
    buffer[i] = charset[key];
  }
}

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
    case CLR:
      return "CLEAR";
    case KILL:
      return "KILL";
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

static inline generic_t run_command_params(int fd, enum Ops command,
                                           generic_t data)
{
  // generate my one time key
  uint64_t data_key;
  uint8_t opcode_key;
  get_key(&opcode_key, &data_key);
  // log before encrypting
  const char* cmd = op_as_string(command);
  DEBUG_PRINT("Sent: [%s][%lu]\n", cmd, data.j);
  DEBUG_PRINT("My key is 0x%02X%016lX\n", opcode_key, data_key);
  // prepare encrypted data
  uint8_t buf[sizeof(void*) + 1];
  data.j = data.j ^ data_key;
  memcpy(buf + 1, &data, sizeof(void*));
  buf[0] = command ^ opcode_key;
  // send data to child
  send(fd, buf, sizeof(void*) + 1, 0);
  // generate child one time key
  get_key(&opcode_key, &data_key);
  // retrieve the data and decrypt it
  recv(fd, buf, sizeof(void*) + 1, 0);
  memcpy(&data, buf + 1, sizeof(void*));
  data.j = data.j ^ data_key;
  cmd = op_as_string(buf[0] ^ opcode_key);
  DEBUG_PRINT("Received: [%s][%lu]\n", cmd, data.j);
  DEBUG_PRINT("The child key was 0x%02X%016lX\n", opcode_key, data_key);
  return data;
}

static inline generic_t run_command(int fd, enum Ops command)
{
  generic_t empty_val;
  ZERO_OUT_UNION(empty_val);
  return run_command_params(fd, command, empty_val);
}

static inline int self_debug(JNIEnv* env, const char* child_process)
{
  char socket_path[2 + SOCKET_NAME_LEN] = {0};
  gen_socket_name(socket_path + 1);
  // create the Process
  jstring child_java_string = (*env)->NewStringUTF(env, child_process);
  jstring socket_path_java_string = (*env)->NewStringUTF(env, socket_path + 1);
  jclass string_class = (*env)->FindClass(env, "java/lang/String");
  jobjectArray func_param =
      (*env)->NewObjectArray(env, 2, string_class, child_java_string);
  (*env)->SetObjectArrayElement(env, func_param, 1, socket_path_java_string);
  jclass pb_class = (*env)->FindClass(env, "java/lang/ProcessBuilder");
  jmethodID method_id =
      (*env)->GetMethodID(env, pb_class, "<init>", "([Ljava/lang/String;)V");
  jobject pb = (*env)->NewObject(env, pb_class, method_id, func_param);
  // setup self-debugging, parent side.
  struct sockaddr_un addr;
  int fd, cl;
  // TODO: remove \0 at beginning for non-linux kernels
  if((fd = socket(AF_UNIX, SOCK_STREAM, 0)) == -1)
    return 0;
  memset(&addr, 0, sizeof(addr));
  addr.sun_family = AF_UNIX;
  *addr.sun_path = '\0';
  strncpy(addr.sun_path + 1, socket_path + 1, sizeof(addr.sun_path) - 2);
  if(bind(fd, (struct sockaddr*)&addr, sizeof(addr)) == -1)
    return 0;
  if(listen(fd, 1) == -1)
    return 0;
  // invoke the process, now the socket exists so the child should wait on the
  // connect() call waiting to be accepted
  method_id =
      (*env)->GetMethodID(env, pb_class, "start", "()Ljava/lang/Process;");
  jobject process = (*env)->CallObjectMethod(env, pb, method_id);
  if((cl = accept(fd, NULL, NULL)) == -1)
    return 0;
  // no more listening
  close(fd);
  // exchange pids
  uint32_t mypid_h = getpid();
  uint32_t mypid_n = htonl(mypid_h);
  uint32_t child_pid_h;
  uint32_t child_pid_n;
  if(read(cl, &child_pid_n, sizeof(uint32_t)) == -1)
    return 0;
  child_pid_h = ntohl(child_pid_n);
  DEBUG_PRINT("Spawned child %d\n", child_pid_h);
  if(write(cl, &mypid_n, sizeof(uint32_t)) == -1)
    return 0;
  // start antidebug operations
  if(prctl(PR_SET_PTRACER, child_pid_h) == -1)
    return 0;
  // filled by me, data passed to child with a POKEDATA into ot_mem_addr
  uint8_t parent_random[32];
  // filled by child with a POKEDATA call
  volatile uint8_t child_random[32];
  // memory address of child_random in my process
  void* my_mem_addr = (void*)child_random;
  // memory address of the parent_random in the other process
  void* ot_mem_addr;
  void* sink;
  send(cl, &my_mem_addr, sizeof(void*), 0);
  recv(cl, &ot_mem_addr, sizeof(void*), 0);
  DEBUG_PRINT("My address is 0x%016lX, Other address is 0x%016lX\n", my_mem_addr,
         ot_mem_addr);
  DEBUG_PRINT("%s\n", "Waiting for child to finish");
  recv(cl, &sink, sizeof(void*), 0);
  DEBUG_PRINT("%s\n", "Child finished");
  if(ptrace(PTRACE_ATTACH, child_pid_h, NULL, NULL) != -1)
  {
    DEBUG_PRINT("%s\n", "Ptrace sent");
    int status;
    waitpid(child_pid_h, &status, 0);
    DEBUG_PRINT("%s\n", "Child stopped");
    getrandom(&parent_random, sizeof(parent_random), 0);
    DEBUG_PRINT("Generated data 0x%016lX 0x%016lX\n", ((uint64_t*)parent_random)[0],
           ((uint64_t*)parent_random)[1]);
    if(WIFSTOPPED(status))
    {
      uint8_t plain[32];
      memcpy(plain, parent_random, sizeof(parent_random));
      ((uint64_t*)plain)[0] += mypid_h;
      ((uint64_t*)plain)[1] += child_pid_h;
      uint8_t encrypted[32];
      encrypt_aes256(plain, sizeof(plain), auth_key, mask_key, encrypted);
      for(int i = 0; i < 4; i++)
      {
        void* data = (void*)(((uint64_t*)encrypted)[i]);
        if(ptrace(PTRACE_POKEDATA, child_pid_h,
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
    ptrace(PTRACE_CONT, child_pid_h, NULL, NULL);
  }
  else
  {
    // fills the parent anyway to avoid having a seed of 0 by chance.
    getrandom(&parent_random, sizeof(parent_random), 0);
  }
  DEBUG_PRINT("%s\n", "Sending resume to child");
  send(cl, &sink, sizeof(void*), 0);
  uint8_t decrypted[32];
  decrypt_aes256(child_random, 32, auth_key, mask_key, decrypted);
  DEBUG_PRINT("Encrypted was 0x%016lX 0x%016lX. ", ((uint64_t*)child_random)[0],
         ((uint64_t*)child_random)[1]);
  DEBUG_PRINT("Decrypted is 0x%016lX 0x%016lX.\n", ((uint64_t*)decrypted)[0],
         ((uint64_t*)decrypted)[1]);
  long_jump = parent_random[20];
  short_jump = decrypted[20];
  prng_state[0] = ((uint64_t*)parent_random)[0];
  prng_state[1] = ((uint64_t*)parent_random)[1];
  prng_state[2] = ((uint64_t*)decrypted)[0] - mypid_h;
  prng_state[3] = ((uint64_t*)decrypted)[1] - child_pid_h;
  DEBUG_PRINT("Seed is 0x%016lX 0x%016lX 0x%016lX 0x%016lX\n", prng_state[0],
         prng_state[1], prng_state[2], prng_state[3]);
  DEBUG_PRINT("Long jump is 0x%02X, Short jump is 0x%02X\n", long_jump, short_jump);

  return cl;
}

/*------------ Originally written by S.Berlato <sberlato@fbk.eu> -------------*\
|                                                                              |
|            ANTI-DEBUGGING PROTECTION AGAINST JAVA-LEVEL DEBUGGER             |
| This method checks whether the "jdwp.so" library, needed for java debugging, |
| has been  loaded. If so, this method overwrites some of the library code     |
| segments with the 0xC3 opcode, that corresponds to "return" in x86 ISA. In   |
| particular, this method sets 0XC3 at the beginning of each function in the   |
| "jdwp.so" library. In this way, the debugger returns without executing the   |
| function (e.g., set breakpoint) and without breaking it. Indeed we want our  |
| Java Anti-Debuggging protection to operate as stealthy as possible           |
| Note: how to know when a function begins in the code segment of the "jdwp.so"|
| library  without having all the addresses? Well, usually each function starts|
| with "push rbp".                                                             |
\*----------------------------------------------------------------------------*/
static inline void break_java_debugger()
{
  // Flag to understand whether we
  // applied the protection or not
  int protection_applied = 0;

  // Get the pid of the process to get
  // the related /proc/<pid>/maps file
  int pid_integer = getpid();

  // Convert the pid from integer to string
  int pid_length = (int)((ceil(log10(pid_integer)) + 1) * sizeof(char));
  char pid_string[pid_length];
  sprintf(pid_string, "%i", pid_integer);

  // Here we concatenate the pid with "/proc/" and
  // "/maps" to create the path of the file to read
  char* file_path = (char*)malloc(strlen("/proc/") + strlen(pid_string) +
                                  strlen("/maps") + 1);
  strcpy(file_path, "/proc/");
  strcat(file_path, pid_string);
  strcat(file_path, "/maps");

  // Check that we are able to open the maps file
  FILE* maps_file = fopen(file_path, "r");
  if(maps_file == NULL)
  {
    exit(-1);
  }

  char* line = NULL;
  size_t len = 0;
  ssize_t read;

  // For each entry in the maps file, if we
  // find the "jdwp" string, we are debugged!
  while((read = getline(&line, &len, maps_file)) != -1)
  {
    if(strstr(line, "jdwp") != NULL)
    {
      // By parsing the line, we retrieve the starting and
      // ending addresses and permissions of the memory page
      char* temp;

      temp = strtok(line, "-");
      char starting_address_hex_char[strlen(temp) + 1];
      strncpy(starting_address_hex_char, temp, strlen(temp) + 1);

      temp = strtok(NULL, " ");
      char ending_address_hex_char[strlen(temp) + 1];
      strncpy(ending_address_hex_char, temp, strlen(temp) + 1);

      temp = strtok(NULL, " ");
      char permission_read = temp[0];
      char permission_write = temp[1];
      char permission_exec = temp[2];

      // We are interested in tampering only the memory page with the
      // 'x' permission, i.e., the memory page with executable code.
      // Indeed, we want our AD protection to be as stealthy as possible
      if(permission_exec == 'x')
      {
        // parse the starting and ending addresses and permissions of the memory
        // page to base 10
        long starting_address_number =
            strtol(starting_address_hex_char, NULL, 16);
        long ending_address_number = strtol(ending_address_hex_char, NULL, 16);
        long difference_address_number =
            ending_address_number - starting_address_number;
        char* starting_address = (char*)starting_address_number;
        char* ending_address = (char*)ending_address_number;

        // Change the flags to be able to write on the memory page to overwrite
        // the code of the debugger. If there were errors in modifying the
        // flags, something is off
        if(mprotect(starting_address, difference_address_number,
                    PROT_READ | PROT_WRITE | PROT_EXEC) == -1)
        {
          exit(-1);
        }
        long i;
        uint8_t* loop_address = (uint8_t*)starting_address;

        // For each byte in the memory page, check whether the byte is the
        // beginning of a function (i.e., the opcode is 0x55 in hex, 85 in dec
        // => 'push rbp'). If so, then overwrite it with the return opcode (0XC3
        // in hex, 195 in dec)
        for(i = 0; i < difference_address_number; i = i + 1l)
        {
          uint8_t byte8 = *loop_address;
          if(byte8 == 0x55)
          {
            *loop_address = 0xC3;
            protection_applied = 1;
          }
          loop_address++;
        }
        // Restore the permission flags of the memory page
        // 5 is '101', that maps in r-x (so read and execute but not write)
        // If there were errors in modifying the flags, something is off
        if(mprotect(starting_address, difference_address_number, 5) == -1)
        {
          exit(-1);
        }
      }
      // This condition is true if we did NOT apply the protection
      if(protection_applied == 0)
      {
        exit(-1);
      }
    }
  }
  fclose(maps_file);
  return;
}

unsigned int child = 0;
unsigned int calls = 0;