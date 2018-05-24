static inline void _int2long(generic_t* stack, uint32_t* index)
{
  generic_t res;
  res.j = (jlong)pop(stack,index).i;
  push2(stack,index,res);
}

static inline void _int2float(generic_t* stack, uint32_t* index)
{
  generic_t res;
  res.f = (jfloat)pop(stack,index).i;
  push(stack,index,res);
}

static inline void _int2double(generic_t* stack, uint32_t* index)
{
  generic_t res;
  res.d = (jdouble)pop(stack,index).i;
  push2(stack,index,res);
}

static inline void _int2byte(generic_t* stack, uint32_t* index)
{
  generic_t res;
  res.i = (jbyte)pop(stack,index).i;
  push(stack,index,res);
}

static inline void _int2char(generic_t* stack, uint32_t* index)
{
  generic_t res;
  res.i = (jchar)pop(stack,index).i;
  push(stack,index,res);
}

static inline void _int2short(generic_t* stack, uint32_t* index)
{
  generic_t res;
  res.i = (jshort)pop(stack,index).i;
  push(stack,index,res);
}

static inline void _long2int(generic_t* stack, uint32_t* index)
{
  generic_t res;
  res.i = (jint)pop2(stack,index).j;
  push(stack,index,res);
}

static inline void _long2float(generic_t* stack, uint32_t* index)
{
  generic_t res;
  res.f = (jfloat)pop2(stack,index).j;
  push(stack,index,res);
}

static inline void _long2double(generic_t* stack, uint32_t* index)
{
  generic_t res;
  res.d = (jdouble)pop2(stack,index).j;
  push2(stack,index,res);
}

static inline void _float2int(generic_t* stack, uint32_t* index)
{
  generic_t res;
  res.i = (jint)pop(stack,index).f;
  push(stack,index,res);
}

static inline void _float2long(generic_t* stack, uint32_t* index)
{
  generic_t res;
  res.j = (jlong)pop(stack,index).f;
  push2(stack,index,res);
}

static inline void _float2double(generic_t* stack, uint32_t* index)
{
  generic_t res;
  res.d = (jdouble)pop(stack,index).f;
  push2(stack,index,res);
}

static inline void _double2int(generic_t* stack, uint32_t* index)
{
  generic_t res;
  res.i = (jint)pop2(stack,index).d;
  push(stack,index,res);
}

static inline void _double2long(generic_t* stack, uint32_t* index)
{
  generic_t res;
  res.j = (jdouble)pop2(stack,index).d;
  push2(stack,index,res);
}

static inline void _double2float(generic_t* stack, uint32_t* index)
{
  generic_t res;
  res.f = (jfloat)pop2(stack,index).d;
  push(stack,index,res);
}

static inline void _InstanceOf(JNIEnv* env, generic_t* stack, uint32_t* index, const char* className)
{
  jobject obj = pop(stack,index).l;
  generic_t res;
  if(obj!=NULL)
  {
    jclass caller_class = (*env)->FindClass(env, className);if(caller_class == NULL){fprintf(stderr,"Class %s not found\n",className);exit(EXIT_FAILURE);}
    res.j ^= res.j; //init to 0
    res.z = (*env)->IsInstanceOf(env,obj,caller_class);
  }
  else
    res.j ^= res.j;
  push(stack,index,res);
}

static inline char _ExceptionInstanceOf(JNIEnv* env, generic_t* stack, const char* exceptionName)
{
  jthrowable obj = stack[0].l;
  //guaranteed that obj is NEVER null, by a previous check
  jclass caller_class = (*env)->FindClass(env, exceptionName);
  return (*env)->IsInstanceOf(env,obj,caller_class);
}

static inline int _CheckCast(JNIEnv* env, generic_t* stack, uint32_t* index, const char* className)
{
  generic_t obj = pop(stack,index);
  if(obj.l!=NULL)
  {
    jclass caller_class = (*env)->FindClass(env, className);if(caller_class == NULL){fprintf(stderr,"Class %s not found\n",className);exit(EXIT_FAILURE);}
    if((*env)->IsInstanceOf(env,obj.l,caller_class))
    {
      push(stack,index,obj);
    }
    else
      return 1;
  }
  else
    push(stack,index,obj);
  return 0;
}
