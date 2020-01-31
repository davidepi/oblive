#include <jni.h>
#include <string.h>//memset
#include <stdint.h> //uint32_t
#include <stdio.h> //fprintf
#include <stdlib.h> //exit
#include <math.h> //fmod used in DRem
#include <time.h> //required by the AntidebugTime and some performance test. Not a big deal if it is unnecessary
#include <sys/prctl.h> // Here starts the includes for the AntidebugSelf Technique
#include <sys/ptrace.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h> // Here ends the includes for the AntidebugSelf Technique

typedef jvalue generic_t;
#define ZERO_OUT_UNION(res) res.j=0
#define OVERFLOW_CHECK(res,check) res.j&=check
#define ARETURN {jvalue __areturn_retval__ = pop(_stack,&_index); return __areturn_retval__.l;}
#define IRETURN {jvalue __ireturn_retval__ = pop(_stack,&_index); return __ireturn_retval__.i;}
#define LRETURN {jvalue __lreturn_retval__ = pop2(_stack,&_index); return __lreturn_retval__.j;}
#define FRETURN {jvalue __freturn_retval__ = pop(_stack,&_index); return __freturn_retval__.f;}
#define DRETURN {jvalue __dreturn_retval__ = pop2(_stack,&_index); return __dreturn_retval__.d;}
#define VRETURN {return;}
