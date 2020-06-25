#include <arpa/inet.h>
#include <jni.h>
#include <math.h>     //fmod used in DRem
#include <stdint.h>   //uint32_t
#include <stdio.h>    //fprintf
#include <stdlib.h>   //exit
#include <string.h>   //memset
#include <sys/mman.h> //To change the protection of invoked libraries (and fuck up the java debugging library)
#include <sys/prctl.h> // Here starts the includes for the AntidebugSelf Technique
#include <sys/ptrace.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <sys/un.h>
#include <sys/wait.h> // Here ends the includes for the AntidebugSelf Technique
#include <time.h> //required by the AntidebugTime and some performance test. Not a big deal if it is unnecessary
#include <unistd.h>

typedef jvalue generic_t;
#define ZERO_OUT_UNION(res) res.j = 0
#define OVERFLOW_CHECK(res, check) res.j &= check
#define ARETURN_SET                         \
  __return_retval__ = pop(_stack, &_index); \
  goto exitpoint;
#define ARETURN_EXEC return __return_retval__.l;
#define IRETURN_SET                         \
  __return_retval__ = pop(_stack, &_index); \
  goto exitpoint;
#define IRETURN_EXEC return __return_retval__.i;
#define LRETURN_SET                          \
  __return_retval__ = pop2(_stack, &_index); \
  goto exitpoint;
#define LRETURN_EXEC return __return_retval__.j;
#define FRETURN_SET                         \
  __return_retval__ = pop(_stack, &_index); \
  goto exitpoint;
#define FRETURN_EXEC return __return_retval__.f;
#define DRETURN_SET                          \
  __return_retval__ = pop2(_stack, &_index); \
  goto exitpoint;
#define DRETURN_EXEC return __return_retval__.d;
#define VRETURN_SET goto exitpoint;
#define VRETURN_EXEC return;
