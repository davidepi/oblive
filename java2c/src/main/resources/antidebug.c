#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <stdint.h>
#include <sys/ptrace.h>
#include <sys/prctl.h>
#include <sys/wait.h>
#include <sys/types.h>

int main(int argc, const char* argv[])
{
    uint32_t me = (uint32_t)getpid();
    pid_t daddy = getppid();
    if(prctl(PR_SET_PTRACER, daddy) != -1)
    {
    }
    else
    {
        exit(EXIT_SUCCESS);
    }
    int status;
    printf("%d", me); //communicate the pid to the parent
    waitpid(daddy, &status, 0);
    exit(EXIT_SUCCESS);
}