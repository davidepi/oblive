#include <arpa/inet.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/prctl.h>
#include <sys/ptrace.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <sys/un.h>
#include <sys/wait.h>
#include <unistd.h>

#define DEFAULT_STACKS 8

const char* op_as_string(enum Ops op) {
    switch(op){
        case STACK: return "STACK";
        case PUSH:return "PUSH";
        case PUSH2:return "PUSH2";
        case POP: return "POP";
        case POP2:return "POP2";
        case DUP:return "DUP";
        case DUP2:return "DUP2";
        case FRONT:return "FRONT";
        case DUPX1:return "DUPX1";
        case DUPX2:return "DUPX2";
        case DUP2X1:return "DUP2X1";
        case DUP2X2:return "DUP2X2";
        case SWAP:return "SWAP";
        case KILL:return "KILL";
        case CLR:return "CLEAR";
        case ACK:return "ACK";
        default:return "UNK";
    }
}

static inline void get_key(uint8_t* opcode_key, uint64_t* data_key)
{
    uint64_t opcode_key_full = next_rng();
    *opcode_key = ((uint8_t*)(&opcode_key_full))[0];
    *data_key = next_rng();
}

static inline enum Ops fetch_command(int fd, void** data, FILE* log)
{
    // get parent key
    uint64_t data_key;
    uint8_t opcode_key;
    get_key(&opcode_key, &data_key);
    // retrieve data
    uint8_t buf[sizeof(void*)+1];
    recv(fd, buf, sizeof(void*)+1, 0);
    memcpy(data, buf+1, sizeof(void*));
    uint8_t cmd = buf[0];
    //decrypt it
    uint64_t data_enc = *data;
    data_enc ^= data_key;
    *data = data_enc;
    cmd ^= opcode_key;
    fprintf(log, "Command: [%s][%lu]\n", op_as_string(cmd), *data);
    fprintf(log, "The parent key was 0x%02X%016lX\n", opcode_key, data_key);
    fflush(log);
    return cmd;
}

static inline void send_result(int fd, void* data, FILE* log)
{
    uint64_t data_key;
    uint8_t opcode_key;
    get_key(&opcode_key, &data_key);
    uint8_t buf[sizeof(void*)+1];
    fprintf(log, "Answer: [%s][%lu]\n", op_as_string(ACK), data);
    fprintf(log, "My key is 0x%02X%016lX\n", opcode_key, data_key);
    fflush(log);
    data = (uint64_t)data ^ data_key;
    // FIXME: possible leak: this ACK is constant, may leak information about the prng
    buf[0] = ACK ^ opcode_key;
    memcpy(buf+1, &data, sizeof(void*));
    send(fd, buf, sizeof(void*)+1, 0);
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
  FILE* log = fopen(log_filename,"w");
  if(send(fd, &mypid_n, sizeof(uint32_t), 0) == -1)
    exit(0);
  if(recv(fd, &parent_pid_n, sizeof(uint32_t), 0) == -1)
    exit(0);
  parent_pid_h = ntohl(parent_pid_n);
  // start antidebug operations
  enum Ops command = !KILL;
  void* data = 0x0;

  // each stack is an instance of a JVM (like a call to a method. Each recursive call needs a new stack)
  // only recursive calls and not async ones! Stacks are expected to die in order!
  size_t cur_stack = -1;
  size_t stacks_allocs = DEFAULT_STACKS;
  void*** stacks = (void***)malloc(sizeof(void**)*stacks_allocs); // void* -> type. ** -> stack *** -> array of stacks
  size_t* stacks_indices = (size_t*)malloc(sizeof(size_t)*stacks_allocs); //each stack needs an index
  uint8_t parent_random[32]; //filled by parent with a POKEDATA call
  uint8_t child_random[32]; //filled by me, data passed to parent with a POKEDATA into ot_mem_addr
  void* my_mem_addr = (void*)parent_random; //memory address of parent_random in my process
  void* ot_mem_addr; //memory address of the child_random in the other process
  void* sink;
  uint64_t small_buf = 0;
  recv(fd, &ot_mem_addr, sizeof(void*), 0);
  if(prctl(PR_SET_PTRACER, parent_pid_h) == -1) {
    fprintf(log, "prctl failure\n");
    exit(0);
    }
  fprintf(log, "My address is 0x%016lX, Other address is 0x%016lX\n", my_mem_addr, ot_mem_addr);
  send(fd, &my_mem_addr, sizeof(void*), 0);
  if(ptrace(PTRACE_ATTACH, parent_pid_h, NULL, NULL) != -1)
  {
    fprintf(log, "Ptraced\n");
    fflush(log);
    int status;
    waitpid(parent_pid_h, &status, 0);
        getrandom(&child_random, sizeof(child_random), 0); //generates the random seed
        fprintf(log, "Generated data 0x%016lX 0x%016lX\n", ((uint64_t*)child_random)[0], ((uint64_t*)child_random)[1]);
      if(WIFSTOPPED(status))
      {
        for(int i=0;i<4;i++)
        {
          void* data = (void*)(((uint64_t*)child_random)[i]);
          if(ptrace(PTRACE_POKEDATA, parent_pid_h, ot_mem_addr+(i*sizeof(void*)), data) == -1)
          {
            fprintf(log,"Poke Failed\n");
          } else
          {
            fprintf(log,"Poked %d/4\n",i+1);
          }
        }
      } else {
        fprintf(log, "Poke not even tried\n");
      }
    fflush(log);
    ptrace(PTRACE_CONT, parent_pid_h, NULL, NULL);
  } else {
    fprintf(log, "Ptrace failed, generating random seed\n");
    fflush(log);
    getrandom(&child_random, sizeof(child_random), 0); //generates the random seed
  }
  kill(parent_pid_h, SIGCONT);
  recv(fd, &sink, sizeof(void*), 0); //wait for the parent to finish writing its part of the data or the seed will be wrong

  long_jump = parent_random[20];
  short_jump = child_random[20];
  prng_state[0] = ((uint64_t*)parent_random)[0];
  prng_state[1] = ((uint64_t*)parent_random)[1];
  prng_state[2] = ((uint64_t*)child_random)[0];
  prng_state[3] = ((uint64_t*)child_random)[1];
  fprintf(log, "Seed is 0x%016lX 0x%016lX 0x%016lX 0x%016lX\n", prng_state[0], prng_state[1], prng_state[2], prng_state[3]);
  fprintf(log, "Long jump is 0x%02X, Short jump is 0x%02X\n", long_jump, short_jump);

  while(command!=KILL || cur_stack != -1)
  {
    command = fetch_command(fd, &data, log);
    switch(command)
    {
        case STACK:
            cur_stack++;
            if (cur_stack == stacks_allocs) {
                fprintf(log, "Requested %d stacks but %d are allocated. Realloc.\n", cur_stack+1, stacks_allocs);
                stacks_allocs<<=1;
                stacks = realloc(stacks, sizeof(void**)*stacks_allocs);
                stacks_indices = realloc(stacks_indices, sizeof(size_t)*stacks_allocs);
                fprintf(log, "Allocated %d stacks\n", stacks_allocs);
            }
            uint64_t stack_len;
            memcpy(&stack_len, &data, sizeof(void*));
            stacks[cur_stack] = (void**)malloc(sizeof(void*)*stack_len);
            stacks_indices[cur_stack] = 0;
            data = cur_stack;
            break;
        case PUSH:{
            stacks[cur_stack][stacks_indices[cur_stack]++] = data;
            data = 0x0;
            break;}
        case PUSH2:{
            stacks[cur_stack][stacks_indices[cur_stack]++] = data;
            stacks_indices[cur_stack]++;
            data = 0x0;
            break;}
        case POP:{
            data = stacks[cur_stack][--stacks_indices[cur_stack]];
            break;}
        case POP2:{
            stacks_indices[cur_stack]--;
            data = stacks[cur_stack][--stacks_indices[cur_stack]];
            break;}
        case DUP:{
            data = 0x0;
            stacks[cur_stack][stacks_indices[cur_stack]] = stacks[cur_stack][stacks_indices[cur_stack]-1];
            stacks_indices[cur_stack]++;
            break;}
        case DUP2:{
            data = 0x0;
            stacks[cur_stack][stacks_indices[cur_stack]] = stacks[cur_stack][stacks_indices[cur_stack]-2];
            stacks[cur_stack][stacks_indices[cur_stack]+1] = stacks[cur_stack][stacks_indices[cur_stack]-1];
            stacks_indices[cur_stack]++;
            stacks_indices[cur_stack]++;
            break;}
        case FRONT:{
            data = stacks[cur_stack][stacks_indices[cur_stack]-1];
            break;}
        case DUPX1:{
            data = 0x0;
            void* dup0 = stacks[cur_stack][--stacks_indices[cur_stack]];
            void* mid0 = stacks[cur_stack][--stacks_indices[cur_stack]];
            stacks[cur_stack][stacks_indices[cur_stack]++] = dup0;
            stacks[cur_stack][stacks_indices[cur_stack]++] = mid0;
            stacks[cur_stack][stacks_indices[cur_stack]++] = dup0;
            break;}
        case DUPX2:{
            data = 0x0;
            void* dup0 = stacks[cur_stack][--stacks_indices[cur_stack]];
            void* mid1 = stacks[cur_stack][--stacks_indices[cur_stack]];
            void* mid0 = stacks[cur_stack][--stacks_indices[cur_stack]];
            stacks[cur_stack][stacks_indices[cur_stack]++] = dup0;
            stacks[cur_stack][stacks_indices[cur_stack]++] = mid0;
            stacks[cur_stack][stacks_indices[cur_stack]++] = mid1;
            stacks[cur_stack][stacks_indices[cur_stack]++] = dup0;
            break;}
        case DUP2X1:
            {data = 0x0;
            void* dup1 = stacks[cur_stack][--stacks_indices[cur_stack]];
            void* dup0 = stacks[cur_stack][--stacks_indices[cur_stack]];
            void* mid0 = stacks[cur_stack][--stacks_indices[cur_stack]];
            stacks[cur_stack][stacks_indices[cur_stack]++] = dup0;
            stacks[cur_stack][stacks_indices[cur_stack]++] = dup1;
            stacks[cur_stack][stacks_indices[cur_stack]++] = mid0;
            stacks[cur_stack][stacks_indices[cur_stack]++] = dup0;
            stacks[cur_stack][stacks_indices[cur_stack]++] = dup1;
            break;}
        case DUP2X2:
            {data = 0x0;
            void* dup1 =stacks[cur_stack][--stacks_indices[cur_stack]];
            void* dup0 = stacks[cur_stack][--stacks_indices[cur_stack]];
            void* mid1 = stacks[cur_stack][--stacks_indices[cur_stack]];
            void* mid0 = stacks[cur_stack][--stacks_indices[cur_stack]];
            stacks[cur_stack][stacks_indices[cur_stack]++] = dup0;
            stacks[cur_stack][stacks_indices[cur_stack]++] = dup1;
            stacks[cur_stack][stacks_indices[cur_stack]++] = mid0;
            stacks[cur_stack][stacks_indices[cur_stack]++] = mid1;
            stacks[cur_stack][stacks_indices[cur_stack]++] = dup0;
            stacks[cur_stack][stacks_indices[cur_stack]++] = dup1;
            break;}
        case SWAP:
           {data = 0x0;
           void* tmp = stacks[cur_stack][stacks_indices[cur_stack]-2];
           stacks[cur_stack][stacks_indices[cur_stack]-2] = stacks[cur_stack][stacks_indices[cur_stack]-1];
           stacks[cur_stack][stacks_indices[cur_stack]-1] = tmp;
           break;}
        case CLR:
            {data = 0x0;
             stacks_indices[cur_stack] = 0;
             break;}
        case KILL:
            free(stacks[cur_stack]);
            data = cur_stack;
            cur_stack--;
            break;
        case ACK:
            data = 0x0;
            break;
        default: //unrecognized command, send normal answer, but reseeds prng so all the next answers will be wrong
            getrandom(&prng_state[0], sizeof(uint64_t), 0);
            getrandom(&prng_state[1], sizeof(uint64_t), 0);
            getrandom(&prng_state[2], sizeof(uint64_t), 0);
            getrandom(&prng_state[3], sizeof(uint64_t), 0);
            exit(0);
    }
    send_result(fd, data, log);
  }
  fclose(log);
  free(stacks_indices);
  free(stacks);
  return 0;
}
