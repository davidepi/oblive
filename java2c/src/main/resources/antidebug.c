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
        case DUPX1:return "DUPX1";
        case DUPX2:return "DUPX2";
        case DUP2X1:return "DUP2X1";
        case DUP2X2:return "DUP2X2";
        case SWAP:return "SWAP";
        case KILL:return "KILL";
        case SYN:return "SYN";
        case ACK:return "ACK";
        default:return "UNK";
    }
}

static inline enum Ops fetch_command(int fd, void** data, FILE* log)
{
    uint8_t buf[sizeof(void*)+1];
    recv(fd, buf, sizeof(void*)+1, 0);
    memcpy(data, buf+1, sizeof(void*));
    fprintf(log, "Command: [%s][%u]\n", op_as_string(buf[0]), *data);
    fflush(log);
    return buf[0];
}

static inline void send_result(int fd, void* data, FILE* log)
{
    uint8_t buf[sizeof(void*)+1];
    memcpy(buf+1, &data, sizeof(void*));
    buf[0] = ACK;
    fprintf(log, "Answer: [%s][%u]\n", op_as_string(buf[0]), data);
    fflush(log);
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
  enum Ops command = SYN;
  void* data = 0x0;

  // each stack is an instance of a JVM (like a call to a method. Each recursive call needs a new stack)
  // only recursive calls and not async ones! Stacks are expected to die in order!
  size_t cur_stack = -1;
  size_t stacks_allocs = DEFAULT_STACKS;
  void*** stacks = (void***)malloc(sizeof(void**)*stacks_allocs); // void* -> type. ** -> stack *** -> array of stacks
  size_t* stacks_indices = (size_t*)malloc(sizeof(size_t)*stacks_allocs); //each stack needs an index

  fetch_command(fd, &data, log);
  if(prctl(PR_SET_PTRACER, parent_pid_h) == -1) {
    fprintf(log, "prctl failure\n");
    exit(0);
    }
  send_result(fd, 0x0, log);
  fetch_command(fd, &data, log);
  if(ptrace(PTRACE_SEIZE, parent_pid_h, NULL, NULL) == -1) {
    fprintf(log, "ptrace failure\n");
    exit(0);
  }
  send_result(fd, 0x0, log);
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
            size_t stack_len;
            memcpy(&stack_len, &data, sizeof(void*));
            stacks[cur_stack] = (void**)malloc(sizeof(void*)*stack_len);
            stacks_indices[cur_stack] = 0;
            data = cur_stack;
            break;
        case PUSH:{
            fprintf(log, "Pushing stack %d position %d, value %u\n", cur_stack, stacks_indices[cur_stack], data);
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
            fprintf(log, "Popping stack %d position %d, value %u\n", cur_stack, stacks_indices[cur_stack], data);
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
        case DUPX1:{
            data = 0x0;
            void* dup0 = stacks[--stacks_indices[cur_stack]];
            void* mid0 = stacks[--stacks_indices[cur_stack]];
            stacks[cur_stack][stacks_indices[cur_stack]++] = dup0;
            stacks[cur_stack][stacks_indices[cur_stack]++] = mid0;
            stacks[cur_stack][stacks_indices[cur_stack]++] = dup0;
            break;}
        case DUPX2:{
            data = 0x0;
            void* dup0 = stacks[--stacks_indices[cur_stack]];
            void* mid1 = stacks[--stacks_indices[cur_stack]];
            void* mid0 = stacks[--stacks_indices[cur_stack]];
            stacks[cur_stack][stacks_indices[cur_stack]++] = dup0;
            stacks[cur_stack][stacks_indices[cur_stack]++] = mid0;
            stacks[cur_stack][stacks_indices[cur_stack]++] = mid1;
            stacks[cur_stack][stacks_indices[cur_stack]++] = dup0;
            break;}
        case DUP2X1:
            {data = 0x0;
            void* dup1 = stacks[--stacks_indices[cur_stack]];
            void* dup0 = stacks[--stacks_indices[cur_stack]];
            void* mid0 = stacks[--stacks_indices[cur_stack]];
            stacks[cur_stack][stacks_indices[cur_stack]++] = dup0;
            stacks[cur_stack][stacks_indices[cur_stack]++] = dup1;
            stacks[cur_stack][stacks_indices[cur_stack]++] = mid0;
            stacks[cur_stack][stacks_indices[cur_stack]++] = dup0;
            stacks[cur_stack][stacks_indices[cur_stack]++] = dup1;
            break;}
        case DUP2X2:
            {void* dup1 =stacks[--stacks_indices[cur_stack]];
            void* dup0 = stacks[--stacks_indices[cur_stack]];
            void* mid1 = stacks[--stacks_indices[cur_stack]];
            void* mid0 = stacks[--stacks_indices[cur_stack]];
            stacks[cur_stack][stacks_indices[cur_stack]++] = dup0;
            stacks[cur_stack][stacks_indices[cur_stack]++] = dup1;
            stacks[cur_stack][stacks_indices[cur_stack]++] = mid0;
            stacks[cur_stack][stacks_indices[cur_stack]++] = mid1;
            stacks[cur_stack][stacks_indices[cur_stack]++] = dup0;
            stacks[cur_stack][stacks_indices[cur_stack]++] = dup1;
            break;}
        case SWAP:
           {void* tmp = stacks[cur_stack][stacks_indices[cur_stack]-2];
           stacks[cur_stack][stacks_indices[cur_stack]-2] = stacks[cur_stack][stacks_indices[cur_stack]-1];
           stacks[cur_stack][stacks_indices[cur_stack]-1] = tmp;
           break;}
        case KILL:
            free(stacks[cur_stack]);
            data = cur_stack;
            cur_stack--;
            break;
        case SYN:
        case ACK:
            data = 0x0;
            break;
        default: //unrecognized command, brutally murder parent, then suicide
            kill(parent_pid_h, SIGKILL);
            exit(0);
    }
    send_result(fd, data, log);
  }
  fclose(log);
  free(stacks_indices);
  free(stacks);
  return 0;
}
