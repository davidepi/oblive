static inline void _int2long(int socket, generic_t* stack, uint32_t* index)
{
  generic_t res;
  res.j = (jlong)pop(socket,stack,index).i;
  push2(socket,stack,index,res);
}

static inline void _int2float(int socket, generic_t* stack, uint32_t* index)
{
  generic_t res;
  res.f = (jfloat)pop(socket,stack,index).i;
  push(socket,stack,index,res);
}

static inline void _int2double(int socket, generic_t* stack, uint32_t* index)
{
  generic_t res;
  res.d = (jdouble)pop(socket,stack,index).i;
  push2(socket,stack,index,res);
}

static inline void _int2byte(int socket, generic_t* stack, uint32_t* index)
{
  generic_t res;
  res.i = (jbyte)pop(socket,stack,index).i;
  push(socket,stack,index,res);
}

static inline void _int2char(int socket, generic_t* stack, uint32_t* index)
{
  generic_t res;
  res.i = (jchar)pop(socket,stack,index).i;
  push(socket,stack,index,res);
}

static inline void _int2short(int socket, generic_t* stack, uint32_t* index)
{
  generic_t res;
  res.i = (jshort)pop(socket,stack,index).i;
  push(socket,stack,index,res);
}

static inline void _long2int(int socket, generic_t* stack, uint32_t* index)
{
  generic_t res;
  res.i = (jint)pop2(socket,stack,index).j;
  push(socket,stack,index,res);
}

static inline void _long2float(int socket, generic_t* stack, uint32_t* index)
{
  generic_t res;
  res.f = (jfloat)pop2(socket,stack,index).j;
  push(socket,stack,index,res);
}

static inline void _long2double(int socket, generic_t* stack, uint32_t* index)
{
  generic_t res;
  res.d = (jdouble)pop2(socket,stack,index).j;
  push2(socket,stack,index,res);
}

static inline void _float2int(int socket, generic_t* stack, uint32_t* index)
{
  generic_t res;
  res.i = (jint)pop(socket,stack,index).f;
  push(socket,stack,index,res);
}

static inline void _float2long(int socket, generic_t* stack, uint32_t* index)
{
  generic_t res;
  res.j = (jlong)pop(socket,stack,index).f;
  push2(socket,stack,index,res);
}

static inline void _float2double(int socket, generic_t* stack, uint32_t* index)
{
  generic_t res;
  res.d = (jdouble)pop(socket,stack,index).f;
  push2(socket,stack,index,res);
}

static inline void _double2int(int socket, generic_t* stack, uint32_t* index)
{
  generic_t res;
  res.i = (jint)pop2(socket,stack,index).d;
  push(socket,stack,index,res);
}

static inline void _double2long(int socket, generic_t* stack, uint32_t* index)
{
  generic_t res;
  res.j = (jdouble)pop2(socket,stack,index).d;
  push2(socket,stack,index,res);
}

static inline void _double2float(int socket, generic_t* stack, uint32_t* index)
{
  generic_t res;
  res.f = (jfloat)pop2(socket,stack,index).d;
  push(socket,stack,index,res);
}

static inline void _InstanceOf(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* className)
{
  jobject obj = pop(socket,stack,index).l;
  generic_t res;
  if(obj!=NULL)
  {
    jclass caller_class = (*env)->FindClass(env, className);if(caller_class == NULL){fprintf(stderr,"Class %s not found\n",className);exit(EXIT_FAILURE);}
    ZERO_OUT_UNION(res);
    res.z = (*env)->IsInstanceOf(env,obj,caller_class);
  }
  else
    ZERO_OUT_UNION(res);
  push(socket,stack,index,res);
}

static inline char _ExceptionInstanceOf(int socket, JNIEnv* env, generic_t* stack, const char* exceptionName)
{
generic_t front;
#ifdef SELF_DEBUG
  front = run_command(socket, FRONT);
#else
  front = stack[0];
#endif
  jthrowable obj = front.l;
  //guaranteed that obj is NEVER null, by a previous check
  jclass caller_class = (*env)->FindClass(env, exceptionName);
  return (*env)->IsInstanceOf(env,obj,caller_class);
}

static inline char _CheckCast(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* className)
{
  generic_t obj = pop(socket,stack,index);
  if(obj.l!=NULL)
  {
    jclass caller_class = (*env)->FindClass(env, className);if(caller_class == NULL){fprintf(stderr,"Class %s not found\n",className);exit(EXIT_FAILURE);}
    if((*env)->IsInstanceOf(env,obj.l,caller_class))
    {
      push(socket,stack,index,obj);
    }
    else
    {
      return 1;
    }
  }
  else
    push(socket,stack,index,obj);
  return 0;
}
