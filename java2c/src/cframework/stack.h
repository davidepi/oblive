static inline void push(generic_t* stack, uint32_t* index, generic_t val)
{
    stack[(*index)++] = val;
}

static inline void push2(generic_t* stack, uint32_t* index, generic_t val)
{
  stack[(*index)++] = val;
  (*index)++;
}

static inline void push0(generic_t* stack, uint32_t* index)
{
  generic_t pushme;
  pushme.l = NULL;
  push(stack,index,pushme);
}

static inline void pushi(generic_t* stack, uint32_t* index, jint val)
{
  generic_t pushme;
  pushme.i = val;
  push(stack,index,pushme);
}

static inline void pushl(generic_t* stack, uint32_t* index, jlong val)
{
  generic_t pushme;
  pushme.j = val;
  push2(stack,index,pushme);
}

static inline void pushf(generic_t* stack, uint32_t* index, jfloat val)
{
  generic_t pushme;
  pushme.f = val;
  push(stack,index,pushme);
}

static inline void pushd(generic_t* stack, uint32_t* index, jdouble val)
{
  generic_t pushme;
  pushme.d = val;
  push2(stack,index,pushme);
}

static inline void _Ldc(JNIEnv* env, generic_t* stack, uint32_t* index, 
                        const jchar* str, int len)
{
  jstring string = (*env)->NewString(env,str,len);
  generic_t pushme;
  pushme.l = string;
  push(stack,index,pushme);
}

static inline generic_t pop(generic_t* stack, uint32_t* index)
{
    return stack[--(*index)];
}

static inline generic_t pop2(generic_t* stack, uint32_t* index)
{
  --(*index);
  return stack[--(*index)];
}

static inline void dup(generic_t* stack, uint32_t* index)
{
  generic_t val = stack[(*index)-1];
  push(stack,index,val);
}

static inline void dup2(generic_t* stack, uint32_t* index)
{
  generic_t val0 = stack[(*index)-2];
  generic_t val1 = stack[(*index)-1];
  push(stack,index,val0);
  push(stack,index,val1);
}

static inline void dupx1(generic_t* stack, uint32_t* index)
{
  generic_t duplicateme = pop(stack,index);
  generic_t middleval = pop(stack,index);
  push(stack,index,duplicateme);
  push(stack,index,middleval);
  push(stack,index,duplicateme);
}

static inline void dupx2(generic_t* stack, uint32_t* index)
{
  generic_t duplicateme = pop(stack,index);
  generic_t middleval1 = pop(stack,index);
  generic_t middleval0 = pop(stack,index);
  push(stack,index,duplicateme);
  push(stack,index,middleval0);
  push(stack,index,middleval1);
  push(stack,index,duplicateme);
}

static inline void dup2x1(generic_t* stack, uint32_t* index)
{
  generic_t duplicateme1 = pop(stack,index);
  generic_t duplicateme0 = pop(stack,index);
  generic_t middleval = pop(stack,index);
  push(stack,index,duplicateme0);
  push(stack,index,duplicateme1);
  push(stack,index,middleval);
  push(stack,index,duplicateme0);
  push(stack,index,duplicateme1);
}

static inline void dup2x2(generic_t* stack, uint32_t* index)
{
  generic_t duplicateme1 = pop(stack,index);
  generic_t duplicateme0 = pop(stack,index);
  generic_t middleval1 = pop(stack,index);
  generic_t middleval0 = pop(stack,index);
  push(stack,index,duplicateme0);
  push(stack,index,duplicateme1);
  push(stack,index,middleval0);
  push(stack,index,middleval1);
  push(stack,index,duplicateme0);
  push(stack,index,duplicateme1);
}

static inline void swap(generic_t* stack, uint32_t* index)
{
  generic_t tmp = stack[(*index)-2];
  stack[(*index)-2] = stack[(*index)-1];
  stack[(*index)-1] = tmp;
}

static inline void _Load(generic_t* stack, generic_t* arg, uint32_t* index, int valueIndex)
{
    push(stack,index,arg[valueIndex]);
}

static inline void _Load2(generic_t* stack, generic_t* arg, uint32_t* index, int valueIndex)
{
    push2(stack,index,arg[valueIndex]);
}

static inline void _Store(generic_t* stack, generic_t* arg, uint32_t* index, int valueIndex)
{
  arg[valueIndex] = pop(stack,index);
}

static inline void _Store2(generic_t* stack, generic_t* arg, uint32_t* index, int valueIndex)
{
  arg[valueIndex] = pop2(stack,index);
}

static inline void _MonitorEnter(JNIEnv* env, generic_t* stack, uint32_t* index)
{
  generic_t lock = pop(stack,index);
  (*env)->MonitorEnter(env, lock.l);
}

static inline void _MonitorExit(JNIEnv* env, generic_t* stack, uint32_t* index)
{
  generic_t lock = pop(stack,index);
  (*env)->MonitorExit(env,lock.l);
}

#define ARETURN {jvalue __areturn_retval__ = pop(_stack,&_index); return __areturn_retval__.l;}
#define IRETURN {jvalue __ireturn_retval__ = pop(_stack,&_index); return __ireturn_retval__.i;}
#define LRETURN {jvalue __lreturn_retval__ = pop2(_stack,&_index); return __lreturn_retval__.j;}
#define FRETURN {jvalue __freturn_retval__ = pop(_stack,&_index); return __freturn_retval__.f;}
#define DRETURN {jvalue __dreturn_retval__ = pop2(_stack,&_index); return __dreturn_retval__.d;}
#define VRETURN {return;}

