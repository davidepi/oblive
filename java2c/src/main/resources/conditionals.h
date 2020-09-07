static inline void icmp(int socket, generic_t* stack, uint32_t* index)
{
  jint b = pop(socket,stack,index).i;
  jint a = pop(socket,stack,index).i;
  generic_t res;
  res.i = a-b;
  if(res.i<0)
    res.i = (jint)-1;
  else if(res.i>0)
    res.i = 1;
  push(socket,stack,index,res);
}

static inline void lcmp(int socket, generic_t* stack, uint32_t* index)
{
    jlong b = pop2(socket,stack,index).j;
    jlong a = pop2(socket,stack,index).j;
    generic_t res;
    res.j = a-b;
    if(res.j<0)
      res.j=(jlong)-1;
    else if(res.j>0)
      res.j=(jlong)1;
    push(socket,stack,index,res);
}

static inline void fcmpl(int socket, generic_t* stack, uint32_t* index)
{
  jfloat b = pop(socket,stack,index).f;
  jfloat a = pop(socket,stack,index).f;
  jfloat res = a-b;
  generic_t pushvar;
  if(res==0)
    pushvar.i = 0;
  else if(res>0)
    pushvar.i = 1;
  else
    pushvar.i = -1; //NaN will fall here
  push(socket,stack,index,pushvar);
}

static inline void fcmpg(int socket, generic_t* stack, uint32_t* index)
{
  jfloat b = pop(socket,stack,index).f;
  jfloat a = pop(socket,stack,index).f;
  jfloat res = a-b;
  generic_t pushvar;
  if(res==0)
    pushvar.i = 0;
  else if(res<0)
    pushvar.i = -1;
  else
    pushvar.i = 1; //NaN will fall here
  push(socket,stack,index,pushvar);
}

static inline void dcmpl(int socket, generic_t* stack, uint32_t* index)
{
  jdouble b = pop2(socket,stack,index).d;
  jdouble a = pop2(socket,stack,index).d;
  jdouble res = a-b;
  generic_t pushvar;
  if(res==0)
    pushvar.i = 0;
  else if(res>0)
    pushvar.i = 1;
  else
    pushvar.i = -1; //NaN will fall here
  push(socket,stack,index,pushvar);
}

static inline void dcmpg(int socket, generic_t* stack, uint32_t* index)
{
  jdouble b = pop2(socket,stack,index).d;
  jdouble a = pop2(socket,stack,index).d;
  jdouble res = a-b;
  generic_t pushvar;
  if(res==0)
    pushvar.i = 0;
  else if(res<0)
    pushvar.i = -1;
  else
    pushvar.i = 1; //NaN will fall here
  push(socket,stack,index,pushvar);
}

static inline void acmp(int socket, JNIEnv* env, generic_t* stack, uint32_t* index)
{
    jobject b = pop(socket,stack,index).l;
    jobject a = pop(socket,stack,index).l;
    generic_t res;
    res.i = (*env)->IsSameObject(env,a,b);
    push(socket,stack,index,res);
}
