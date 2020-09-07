static inline void _IAdd(int socket, generic_t* stack, uint32_t* index)
{
    jint b = pop(socket,stack,index).i;
    jint a = pop(socket,stack,index).i;
    generic_t res;
    res.i = a+b;
    push(socket,stack,index,res);
}

static inline void _LAdd(int socket, generic_t* stack, uint32_t* index)
{
  jlong b = pop2(socket,stack,index).j;
  jlong a = pop2(socket,stack,index).j;
  generic_t res;
  res.j = a+b;
  push2(socket,stack,index,res);
}

static inline void _FAdd(int socket, generic_t* stack, uint32_t* index)
{
  jfloat b = pop(socket,stack,index).f;
  jfloat a = pop(socket,stack,index).f;
  generic_t res;
  res.f = a+b;
  push(socket,stack,index,res);
}

static inline void _DAdd(int socket, generic_t* stack, uint32_t* index)
{
  jdouble b = pop2(socket,stack,index).d;
  jdouble a = pop2(socket,stack,index).d;
  generic_t res;
  res.d = a+b;
  push2(socket,stack,index,res);
}

static inline void _ISub(int socket, generic_t* stack, uint32_t* index)
{
    jint b = pop(socket,stack,index).i;
    jint a = pop(socket,stack,index).i;
    generic_t res;
    res.i = a-b;
    push(socket,stack,index,res);
}

static inline void _LSub(int socket, generic_t* stack, uint32_t* index)
{
  jlong b = pop2(socket,stack,index).j;
  jlong a = pop2(socket,stack,index).j;
  generic_t res;
  res.j = a-b;
  push2(socket,stack,index,res);
}

static inline void _FSub(int socket, generic_t* stack, uint32_t* index)
{
  jfloat b = pop(socket,stack,index).f;
  jfloat a = pop(socket,stack,index).f;
  generic_t res;
  res.f = a-b;
  push(socket,stack,index,res);
}

static inline void _DSub(int socket, generic_t* stack, uint32_t* index)
{
  jdouble b = pop2(socket,stack,index).d;
  jdouble a = pop2(socket,stack,index).d;
  generic_t res;
  res.d = a-b;
  push2(socket,stack,index,res);
}

static inline void _IMul(int socket, generic_t* stack, uint32_t* index)
{
    jint b = pop(socket,stack,index).i;
    jint a = pop(socket,stack,index).i;
    generic_t res;
    res.i = a*b;
    push(socket,stack,index,res);
}

static inline void _LMul(int socket, generic_t* stack, uint32_t* index)
{
  jlong b = pop2(socket,stack,index).j;
  jlong a = pop2(socket,stack,index).j;
  generic_t res;
  res.j = a*b;
  push2(socket,stack,index,res);
}

static inline void _FMul(int socket, generic_t* stack, uint32_t* index)
{
  jfloat b = pop(socket,stack,index).f;
  jfloat a = pop(socket,stack,index).f;
  generic_t res;
  res.f = a*b;
  push(socket,stack,index,res);
}

static inline void _DMul(int socket, generic_t* stack, uint32_t* index)
{
  jdouble b = pop2(socket,stack,index).d;
  jdouble a = pop2(socket,stack,index).d;
  generic_t res;
  res.d = a*b;
  push2(socket,stack,index,res);
}

static inline char _IDiv(int socket, generic_t* stack, uint32_t* index)
{
    char retval = 0;
    jint b = pop(socket,stack,index).i;
    jint a = pop(socket,stack,index).i;
    if(b!=0)
    {
      generic_t res;
      res.i = a/b;
      push(socket,stack,index,res);
    }
    else
      retval = 1;
    return retval;
}

static inline char _LDiv(int socket, generic_t* stack, uint32_t* index)
{
  char retval = 0;
  jlong b = pop2(socket,stack,index).j;
  jlong a = pop2(socket,stack,index).j;
  if(b!=0)
  {
    generic_t res;
    res.j = a/b;
    push2(socket,stack,index,res);
  }
  else
    retval = 1;
  return retval;
}

static inline void _FDiv(int socket, generic_t* stack, uint32_t* index)
{
  jfloat b = pop(socket,stack,index).f;
  jfloat a = pop(socket,stack,index).f;
  generic_t res;
  res.f = a/b;
  push(socket,stack,index,res);
}

static inline void _DDiv(int socket, generic_t* stack, uint32_t* index)
{
  jdouble b = pop2(socket,stack,index).d;
  jdouble a = pop2(socket,stack,index).d;
  generic_t res;
  res.d = a/b;
  push2(socket,stack,index,res);
}

static inline char _IRem(int socket, generic_t* stack, uint32_t* index)
{
  char retval = 0;
    jint b = pop(socket,stack,index).i;
    jint a = pop(socket,stack,index).i;
    if(b!=0)
    {
      generic_t res;
      res.i = a%b;
      push(socket,stack,index,res);
    }
    else
      retval = 1;
    return retval;
}

static inline char _LRem(int socket, generic_t* stack, uint32_t* index)
{
  char retval = 0;
  jlong b = pop2(socket,stack,index).j;
  jlong a = pop2(socket,stack,index).j;
  if(b!=0)
  {
    generic_t res;
    res.j = a%b;
    push2(socket,stack,index,res);
  }
  else
    retval = 1;
  return retval;
}

static inline void _FRem(int socket, generic_t* stack, uint32_t* index)
{
  jfloat b = pop(socket,stack,index).f;
  jfloat a = pop(socket,stack,index).f;
  generic_t res;
  res.f = fmodf(a,b);
  push(socket,stack,index,res);
}

static inline void _DRem(int socket, generic_t* stack, uint32_t* index)
{
  jdouble b = pop2(socket,stack,index).d;
  jdouble a = pop2(socket,stack,index).d;
  generic_t res;
  res.d = fmod(a,b);
  push2(socket,stack,index,res);
}

static inline void _INeg(int socket, generic_t* stack, uint32_t* index)
{
    jint a = pop(socket,stack,index).i;
    generic_t res;
    res.i = -a;
    push(socket,stack,index,res);
}

static inline void _LNeg(int socket, generic_t* stack, uint32_t* index)
{
  jlong a = pop2(socket,stack,index).j;
  generic_t res;
  res.j = -a;
  push2(socket,stack,index,res);
}

static inline void _FNeg(int socket, generic_t* stack, uint32_t* index)
{
  jfloat a = pop(socket,stack,index).f;
  generic_t res;
  res.f = -a;
  push(socket,stack,index,res);
}

static inline void _DNeg(int socket, generic_t* stack, uint32_t* index)
{
  jdouble a = pop2(socket,stack,index).d;
  generic_t res;
  res.d = -a;
  push2(socket,stack,index,res);
}

static inline void _IShl(int socket, generic_t* stack, uint32_t* index)
{
    jint b = pop(socket,stack,index).i;
    jint a = pop(socket,stack,index).i;
    generic_t res;
    res.i = a<<b;
    push(socket,stack,index,res);
}

static inline void _LShl(int socket, generic_t* stack, uint32_t* index)
{
  jint b = pop(socket,stack,index).j;
  jlong a = pop2(socket,stack,index).j;
  generic_t res;
  res.j = a<<b;
  push2(socket,stack,index,res);
}

static inline void _IShr(int socket, generic_t* stack, uint32_t* index)
{
    jint b = pop(socket,stack,index).i;
    jint a = pop(socket,stack,index).i;
    generic_t res;
    res.i = a>>b;
    push(socket,stack,index,res);
}

static inline void _LShr(int socket, generic_t* stack, uint32_t* index)
{
  jint b = pop(socket,stack,index).j;
  jlong a = pop2(socket,stack,index).j;
  generic_t res;
  res.j = a>>b;
  push2(socket,stack,index,res);
}

static inline void _IUShr(int socket, generic_t* stack, uint32_t* index)
{
    jint b = pop(socket,stack,index).i;
    //this cast ensures logical shift
    unsigned int a = (unsigned int)(pop(socket,stack,index).i);
    generic_t res;
    res.i = a>>b;
    push(socket,stack,index,res);
}

static inline void _LUShr(int socket, generic_t* stack, uint32_t* index)
{
  jint b = pop(socket,stack,index).j;
  //this cast ensures logical shift
  unsigned long long int a = (unsigned long long int)(pop2(socket,stack,index).j);
  generic_t res;
  res.j = a>>b;
  push2(socket,stack,index,res);
}

static inline void _IAnd(int socket, generic_t* stack, uint32_t* index)
{
    jint b = pop(socket,stack,index).i;
    jint a = pop(socket,stack,index).i;
    generic_t res;
    res.i = a&b;
    push(socket,stack,index,res);
}

static inline void _LAnd(int socket, generic_t* stack, uint32_t* index)
{
  jlong b = pop2(socket,stack,index).j;
  jlong a = pop2(socket,stack,index).j;
  generic_t res;
  res.j = a&b;
  push2(socket,stack,index,res);
}

static inline void _IOr(int socket, generic_t* stack, uint32_t* index)
{
    jint b = pop(socket,stack,index).i;
    jint a = pop(socket,stack,index).i;
    generic_t res;
    res.i = a|b;
    push(socket,stack,index,res);
}

static inline void _LOr(int socket, generic_t* stack, uint32_t* index)
{
  jlong b = pop2(socket,stack,index).j;
  jlong a = pop2(socket,stack,index).j;
  generic_t res;
  res.j = a|b;
  push2(socket,stack,index,res);
}

static inline void _IXor(int socket, generic_t* stack, uint32_t* index)
{
    jint b = pop(socket,stack,index).i;
    jint a = pop(socket,stack,index).i;
    generic_t res;
    res.i = a^b;
    push(socket,stack,index,res);
}

static inline void _LXor(int socket, generic_t* stack, uint32_t* index)
{
  jlong b = pop2(socket,stack,index).j;
  jlong a = pop2(socket,stack,index).j;
  generic_t res;
  res.j = a^b;
  push2(socket,stack,index,res);
}

static inline void _Iinc(int socket,generic_t* vars, int varindex, int increment)
{
  (vars[varindex].i)+=increment;
}

