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

void synchronize(int fd)
{
  int sync = 0;
  recv(fd, &sync, 1, 0);
  send(fd, &sync, 1, 0);
}

int main(int argc, const char* argv[])
{
  struct sockaddr_un addr;
  char socket_path[34] = {0};
  char buf[100];
  int fd, cl, rc;
  // TODO: remove \0 at beginning for non-linux kernels
  strncpy(socket_path + 1, argv[1], 32);
  if((fd = socket(AF_UNIX, SOCK_STREAM, 0)) == -1)
  {
    perror("socket error");
    exit(-1);
  }

  int sync;
  memset(&addr, 0, sizeof(addr));
  addr.sun_family = AF_UNIX;
  *addr.sun_path = '\0';
  strncpy(addr.sun_path + 1, socket_path + 1, sizeof(addr.sun_path) - 2);

  if(connect(fd, (struct sockaddr*)&addr, sizeof(addr)) == -1)
  {
    perror("connect error");
    exit(-1);
  }
  uint32_t mypid_h = getpid();
  printf("My pid: %d\n", mypid_h);
  uint32_t mypid_n = htonl(mypid_h);
  uint32_t parent_pid_h;
  uint32_t parent_pid_n;
  if(send(fd, &mypid_n, sizeof(uint32_t), 0) == -1)
  {
    perror("send error");
    exit(-1);
  }

  if(recv(fd, &parent_pid_n, sizeof(uint32_t), 0) == -1)
  {
    perror("receive error");
    exit(-1);
  }
  parent_pid_h = ntohl(parent_pid_n);
  printf("parent: %d\n", parent_pid_h);
  // start antidebug operations
  if(prctl(PR_SET_PTRACER, parent_pid_h) == -1)
  {
    printf("prctl failed\n");
    exit(0);
  }
  else
  {
    printf("prctld\n");
  }
  synchronize(fd);
  if(ptrace(PTRACE_SEIZE, parent_pid_h, NULL, NULL) == -1)
  {
    printf("ptrace failed");
    exit(0);
  }
  else
  {
    printf("ptraced\n");
  }
  synchronize(fd);
  printf("waiting\n");
  synchronize(fd);
}
