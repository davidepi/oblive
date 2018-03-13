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

#define ARETURN {jvalue __areturn_retval__ = pop(_stack,&_index); return __areturn_retval__.l;}
#define IRETURN {jvalue __ireturn_retval__ = pop(_stack,&_index); return __ireturn_retval__.i;}
#define LRETURN {jvalue __lreturn_retval__ = pop2(_stack,&_index); return __lreturn_retval__.j;}
#define FRETURN {jvalue __freturn_retval__ = pop(_stack,&_index); return __freturn_retval__.f;}
#define DRETURN {jvalue __dreturn_retval__ = pop2(_stack,&_index); return __dreturn_retval__.d;}
#define VRETURN {return;}

