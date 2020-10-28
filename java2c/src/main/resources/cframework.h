#include <arpa/inet.h>
#include <jni.h>
#include <math.h>   //fmod used in DRem
#include <stdint.h> //uint32_t
#include <stdio.h>  //fprintf
#include <stdlib.h> //exit
#include <string.h> //memset
#include <unistd.h>

typedef jvalue generic_t;
#define ZERO_OUT_UNION(res) res.j = 0
#define OVERFLOW_CHECK(res, check) res.j &= check
#define ARETURN_SET                                \
  __return_retval__ = pop(child, _stack, &_index); \
  goto exitpoint;
#define ARETURN_EXEC return __return_retval__.l;
#define IRETURN_SET                                \
  __return_retval__ = pop(child, _stack, &_index); \
  goto exitpoint;
#define IRETURN_EXEC return __return_retval__.i;
#define LRETURN_SET                                 \
  __return_retval__ = pop2(child, _stack, &_index); \
  goto exitpoint;
#define LRETURN_EXEC return __return_retval__.j;
#define FRETURN_SET                                \
  __return_retval__ = pop(child, _stack, &_index); \
  goto exitpoint;
#define FRETURN_EXEC return __return_retval__.f;
#define DRETURN_SET                                 \
  __return_retval__ = pop2(child, _stack, &_index); \
  goto exitpoint;
#define DRETURN_EXEC return __return_retval__.d;
#define VRETURN_SET goto exitpoint;
#define VRETURN_EXEC return;
