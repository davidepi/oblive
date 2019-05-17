#include <jni.h>
#include <string.h>//memset
#include <stdint.h> //uint32_t
#include <stdio.h> //fprintf
#include <stdlib.h> //exit
#include <math.h> //fmod used in DRem
#define NOP //this is used essentially as a flag. In performance tests will be replaced by #include <time.h>
typedef jvalue generic_t;
#define ZERO_OUT_UNION(res) res.j=0
#define OVERFLOW_CHECK(res,check) res.j&=check
#define ARETURN {jvalue __areturn_retval__ = pop(_stack,&_index); return __areturn_retval__.l;}
#define IRETURN {jvalue __ireturn_retval__ = pop(_stack,&_index); return __ireturn_retval__.i;}
#define LRETURN {jvalue __lreturn_retval__ = pop2(_stack,&_index); return __lreturn_retval__.j;}
#define FRETURN {jvalue __freturn_retval__ = pop(_stack,&_index); return __freturn_retval__.f;}
#define DRETURN {jvalue __dreturn_retval__ = pop2(_stack,&_index); return __dreturn_retval__.d;}
#define VRETURN {return;}
