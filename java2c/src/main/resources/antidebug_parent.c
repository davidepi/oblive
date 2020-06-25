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
  send(fd, &sync, 1, 0);
  recv(fd, &sync, 1, 0);
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

  memset(&addr, 0, sizeof(addr));
  addr.sun_family = AF_UNIX;
  *addr.sun_path = '\0';
  strncpy(addr.sun_path + 1, socket_path + 1, sizeof(addr.sun_path) - 2);

  if(bind(fd, (struct sockaddr*)&addr, sizeof(addr)) == -1)
  {
    perror("bind error");
    exit(-1);
  }
  if(listen(fd, 5) == -1)
  {
    perror("listen error");
    exit(-1);
  }
  if((cl = accept(fd, NULL, NULL)) == -1)
  {
    perror("accept error");
    exit(-1);
  }
  uint32_t mypid_h = getpid();
  printf("My pid: %d\n", mypid_h);
  uint32_t mypid_n = htonl(mypid_h);
  uint32_t child_pid_h;
  uint32_t child_pid_n;
  if(read(cl, &child_pid_n, sizeof(uint32_t)) == -1)
  {
    perror("receive error");
    exit(-1);
  }
  child_pid_h = ntohl(child_pid_n);
  printf("child: %d\n", child_pid_h);
  if(write(cl, &mypid_n, sizeof(uint32_t)) == -1)
  {
    perror("send error");
    exit(-1);
  }
  // start antidebug operations
  if(prctl(PR_SET_PTRACER, child_pid_h) == -1)
  {
    printf("prctl failed\n");
    exit(0);
  }
  else
  {
    printf("prctld\n");
  }
  synchronize(cl);
  if(ptrace(PTRACE_SEIZE, child_pid_h, NULL, NULL) == -1)
  {
    printf("ptrace failed");
    exit(0);
  }
  else
  {
    printf("ptraced\n");
  }
  synchronize(cl);
  // insert computation here
  synchronize(cl);
}
