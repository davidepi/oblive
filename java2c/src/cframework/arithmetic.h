#include <math.h>
static inline void _IAdd(generic_t* stack, uint32_t* index)
{
    jint b = pop(stack,index).i;
    jint a = pop(stack,index).i;
    generic_t res;
    res.i = a+b;
    push(stack,index,res);
}

static inline void _LAdd(generic_t* stack, uint32_t* index)
{
  jlong b = pop2(stack,index).j;
  jlong a = pop2(stack,index).j;
  generic_t res;
  res.j = a+b;
  push2(stack,index,res);
}

static inline void _FAdd(generic_t* stack, uint32_t* index)
{
  jfloat b = pop(stack,index).f;
  jfloat a = pop(stack,index).f;
  generic_t res;
  res.f = a+b;
  push(stack,index,res);
}

static inline void _DAdd(generic_t* stack, uint32_t* index)
{
  jdouble b = pop2(stack,index).d;
  jdouble a = pop2(stack,index).d;
  generic_t res;
  res.d = a+b;
  push2(stack,index,res);
}

static inline void _ISub(generic_t* stack, uint32_t* index)
{
    jint b = pop(stack,index).i;
    jint a = pop(stack,index).i;
    generic_t res;
    res.i = a-b;
    push(stack,index,res);
}

static inline void _LSub(generic_t* stack, uint32_t* index)
{
  jlong b = pop2(stack,index).j;
  jlong a = pop2(stack,index).j;
  generic_t res;
  res.j = a-b;
  push2(stack,index,res);
}

static inline void _FSub(generic_t* stack, uint32_t* index)
{
  jfloat b = pop(stack,index).f;
  jfloat a = pop(stack,index).f;
  generic_t res;
  res.f = a-b;
  push(stack,index,res);
}

static inline void _DSub(generic_t* stack, uint32_t* index)
{
  jdouble b = pop2(stack,index).d;
  jdouble a = pop2(stack,index).d;
  generic_t res;
  res.d = a-b;
  push2(stack,index,res);
}

static inline void _IMul(generic_t* stack, uint32_t* index)
{
    jint b = pop(stack,index).i;
    jint a = pop(stack,index).i;
    generic_t res;
    res.i = a*b;
    push(stack,index,res);
}

static inline void _LMul(generic_t* stack, uint32_t* index)
{
  jlong b = pop2(stack,index).j;
  jlong a = pop2(stack,index).j;
  generic_t res;
  res.j = a*b;
  push2(stack,index,res);
}

static inline void _FMul(generic_t* stack, uint32_t* index)
{
  jfloat b = pop(stack,index).f;
  jfloat a = pop(stack,index).f;
  generic_t res;
  res.f = a*b;
  push(stack,index,res);
}

static inline void _DMul(generic_t* stack, uint32_t* index)
{
  jdouble b = pop2(stack,index).d;
  jdouble a = pop2(stack,index).d;
  generic_t res;
  res.d = a*b;
  push2(stack,index,res);
}

static inline void _IDiv(generic_t* stack, uint32_t* index)
{
    jint b = pop(stack,index).i;
    jint a = pop(stack,index).i;
    generic_t res;
    res.i = a/b;
    push(stack,index,res);
}

static inline void _LDiv(generic_t* stack, uint32_t* index)
{
  jlong b = pop2(stack,index).j;
  jlong a = pop2(stack,index).j;
  generic_t res;
  res.j = a/b;
  push2(stack,index,res);
}

static inline void _FDiv(generic_t* stack, uint32_t* index)
{
  jfloat b = pop(stack,index).f;
  jfloat a = pop(stack,index).f;
  generic_t res;
  res.f = a/b;
  push(stack,index,res);
}

static inline void _DDiv(generic_t* stack, uint32_t* index)
{
  jdouble b = pop2(stack,index).d;
  jdouble a = pop2(stack,index).d;
  generic_t res;
  res.d = a/b;
  push2(stack,index,res);
}

static inline void _IRem(generic_t* stack, uint32_t* index)
{
    jint b = pop(stack,index).i;
    jint a = pop(stack,index).i;
    generic_t res;
    res.i = a%b;
    push(stack,index,res);
}

static inline void _LRem(generic_t* stack, uint32_t* index)
{
  jlong b = pop2(stack,index).j;
  jlong a = pop2(stack,index).j;
  generic_t res;
  res.j = a%b;
  push2(stack,index,res);
}

static inline void _FRem(generic_t* stack, uint32_t* index)
{
  jfloat b = pop(stack,index).f;
  jfloat a = pop(stack,index).f;
  generic_t res;
  res.f = fmodf(a,b);
  push(stack,index,res);
}

static inline void _DRem(generic_t* stack, uint32_t* index)
{
  jdouble b = pop2(stack,index).d;
  jdouble a = pop2(stack,index).d;
  generic_t res;
  res.d = fmod(a,b);
  push2(stack,index,res);
}

static inline void _INeg(generic_t* stack, uint32_t* index)
{
    jint a = pop(stack,index).i;
    generic_t res;
    res.i = -a;
    push(stack,index,res);
}

static inline void _LNeg(generic_t* stack, uint32_t* index)
{
  jlong a = pop2(stack,index).j;
  generic_t res;
  res.j = -a;
  push2(stack,index,res);
}

static inline void _FNeg(generic_t* stack, uint32_t* index)
{
  jfloat a = pop(stack,index).f;
  generic_t res;
  res.f = -a;
  push(stack,index,res);
}

static inline void _DNeg(generic_t* stack, uint32_t* index)
{
  jdouble a = pop2(stack,index).d;
  generic_t res;
  res.d = -a;
  push2(stack,index,res);
}

static inline void _IShl(generic_t* stack, uint32_t* index)
{
    jint b = pop(stack,index).i;
    jint a = pop(stack,index).i;
    generic_t res;
    res.i = a<<b;
    push(stack,index,res);
}

static inline void _LShl(generic_t* stack, uint32_t* index)
{
  jint b = pop(stack,index).j;
  jlong a = pop2(stack,index).j;
  generic_t res;
  res.j = a<<b;
  push2(stack,index,res);
}

static inline void _IShr(generic_t* stack, uint32_t* index)
{
    jint b = pop(stack,index).i;
    jint a = pop(stack,index).i;
    generic_t res;
    res.i = a>>b;
    push(stack,index,res);
}

static inline void _LShr(generic_t* stack, uint32_t* index)
{
  jint b = pop(stack,index).j;
  jlong a = pop2(stack,index).j;
  generic_t res;
  res.j = a>>b;
  push2(stack,index,res);
}

static inline void _IUShr(generic_t* stack, uint32_t* index)
{
    jint b = pop(stack,index).i;
    //this cast ensures logical shift
    unsigned int a = (unsigned int)(pop(stack,index).i);
    generic_t res;
    res.i = a>>b;
    push(stack,index,res);
}

static inline void _LUShr(generic_t* stack, uint32_t* index)
{
  jint b = pop(stack,index).j;
  //this cast ensures logical shift
  unsigned long long int a = (unsigned long long int)(pop2(stack,index).j);
  generic_t res;
  res.j = a>>b;
  push2(stack,index,res);
}

static inline void _IAnd(generic_t* stack, uint32_t* index)
{
    jint b = pop(stack,index).i;
    jint a = pop(stack,index).i;
    generic_t res;
    res.i = a&b;
    push(stack,index,res);
}

static inline void _LAnd(generic_t* stack, uint32_t* index)
{
  jlong b = pop2(stack,index).j;
  jlong a = pop2(stack,index).j;
  generic_t res;
  res.j = a&b;
  push2(stack,index,res);
}

static inline void _IOr(generic_t* stack, uint32_t* index)
{
    jint b = pop(stack,index).i;
    jint a = pop(stack,index).i;
    generic_t res;
    res.i = a|b;
    push(stack,index,res);
}

static inline void _LOr(generic_t* stack, uint32_t* index)
{
  jlong b = pop2(stack,index).j;
  jlong a = pop2(stack,index).j;
  generic_t res;
  res.j = a|b;
  push2(stack,index,res);
}

static inline void _IXor(generic_t* stack, uint32_t* index)
{
    jint b = pop(stack,index).i;
    jint a = pop(stack,index).i;
    generic_t res;
    res.i = a^b;
    push(stack,index,res);
}

static inline void _LXor(generic_t* stack, uint32_t* index)
{
  jlong b = pop2(stack,index).j;
  jlong a = pop2(stack,index).j;
  generic_t res;
  res.j = a^b;
  push2(stack,index,res);
}

static inline void _Iinc(generic_t* vars, int varindex, int increment)
{
  (vars[varindex].i)+=increment;
}
