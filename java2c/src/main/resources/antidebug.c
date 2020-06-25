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

static inline void self_debug_end(int fd)
{
  synchronize(fd);
  close(fd);
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
  if(send(fd, &mypid_n, sizeof(uint32_t), 0) == -1)
    exit(0);
  if(recv(fd, &parent_pid_n, sizeof(uint32_t), 0) == -1)
    exit(0);
  parent_pid_h = ntohl(parent_pid_n);
  // start antidebug operations
  if(prctl(PR_SET_PTRACER, parent_pid_h) == -1)
    exit(0);
  synchronize(fd);
  if(ptrace(PTRACE_SEIZE, parent_pid_h, NULL, NULL) == -1)
    exit(0);
  synchronize(fd);
  // printf("waiting\n");
  synchronize(fd);
}
