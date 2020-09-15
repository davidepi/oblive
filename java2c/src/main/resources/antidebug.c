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

//TODO: generate this dynamically
#define STACK_SIZE 999

#ifndef STACK_SIZE
#error "stack size not defined"
#endif

const char* op_as_string(enum Ops op) {
    switch(op){
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
  FILE* log = fopen("/tmp/log_child.txt","w");
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
  if(send(fd, &mypid_n, sizeof(uint32_t), 0) == -1)
    exit(0);
  if(recv(fd, &parent_pid_n, sizeof(uint32_t), 0) == -1)
    exit(0);
  parent_pid_h = ntohl(parent_pid_n);
  // start antidebug operations
  enum Ops command = SYN;
  void* data = 0x0;
  size_t stack_index = 0;
  void* stack[STACK_SIZE];

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
  while(command != KILL)
  {
    command = fetch_command(fd, &data, log);
    switch(command)
    {
        case PUSH:{
            stack[stack_index++] = data;
            data = 0x0;
            break;}
        case PUSH2:{
            stack[stack_index++] = data;
            stack_index++;
            data = 0x0;
            break;}
        case POP:{
            data = stack[--stack_index];
            break;}
        case POP2:{
            stack_index--;
            data = stack[--stack_index];
            break;}
        case DUP:{
            data = 0x0;
            stack[stack_index] = stack[stack_index-1];
            stack_index++;
            break;}
        case DUP2:{
            data = 0x0;
            stack[stack_index] = stack[stack_index-2];
            stack[stack_index+1] = stack[stack_index-1];
            stack_index++;
            stack_index++;
            break;}
        case DUPX1:{
            data = 0x0;
            void* dup0 = stack[--stack_index];
            void* mid0 = stack[--stack_index];
            stack[stack_index++] = dup0;
            stack[stack_index++] = mid0;
            stack[stack_index++] = dup0;
            break;}
        case DUPX2:{
            data = 0x0;
            void* dup0 = stack[--stack_index];
            void* mid1 = stack[--stack_index];
            void* mid0 = stack[--stack_index];
            stack[stack_index++] = dup0;
            stack[stack_index++] = mid0;
            stack[stack_index++] = mid1;
            stack[stack_index++] = dup0;
            break;}
        case DUP2X1:
            {data = 0x0;
            void* dup1 = stack[--stack_index];
            void* dup0 = stack[--stack_index];
            void* mid0 = stack[--stack_index];
            stack[stack_index++] = dup0;
            stack[stack_index++] = dup1;
            stack[stack_index++] = mid0;
            stack[stack_index++] = dup0;
            stack[stack_index++] = dup1;
            break;}
        case DUP2X2:
            {void* dup1 = stack[--stack_index];
            void* dup0 = stack[--stack_index];
            void* mid1 = stack[--stack_index];
            void* mid0 = stack[--stack_index];
            stack[stack_index++] = dup0;
            stack[stack_index++] = dup1;
            stack[stack_index++] = mid0;
            stack[stack_index++] = mid1;
            stack[stack_index++] = dup0;
            stack[stack_index++] = dup1;
            break;}
        case SWAP:
           {void* tmp = stack[stack_index-2];
           stack[stack_index-2] = stack[stack_index-1];
           stack[stack_index-1] = tmp;
           break;}
        case KILL:
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
  return 0;
}
