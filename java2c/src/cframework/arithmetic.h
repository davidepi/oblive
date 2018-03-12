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
