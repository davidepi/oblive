static inline void icmp(generic_t* stack, uint32_t* index)
{
  jint b = pop(stack,index).i;
  jint a = pop(stack,index).i;
  generic_t res;
  res.i = a-b;
  if(res.i<0)
    res.i = (jint)-1;
  else if(res.i>0)
    res.i = 1;
  push(stack,index,res);
}

static inline void lcmp(generic_t* stack, uint32_t* index)
{
    jlong b = pop2(stack,index).j;
    jlong a = pop2(stack,index).j;
    generic_t res;
    res.j = a-b;
    if(res.j<0)
      res.j=(jlong)-1;
    else if(res.j>0)
      res.j=(jlong)1;
    push(stack,index,res);
}

static inline void fcmpl(generic_t* stack, uint32_t* index)
{
  jfloat b = pop(stack,index).f;
  jfloat a = pop(stack,index).f;
  jfloat res = a-b;
  generic_t pushvar;
  if(res==0)
    pushvar.i = 0;
  else if(res>0)
    pushvar.i = 1;
  else
    pushvar.i = -1; //NaN will fall here
  push(stack,index,pushvar);
}

static inline void fcmpg(generic_t* stack, uint32_t* index)
{
  jfloat b = pop(stack,index).f;
  jfloat a = pop(stack,index).f;
  jfloat res = a-b;
  generic_t pushvar;
  if(res==0)
    pushvar.i = 0;
  else if(res<0)
    pushvar.i = -1;
  else
    pushvar.i = 1; //NaN will fall here
  push(stack,index,pushvar);
}

static inline void dcmpl(generic_t* stack, uint32_t* index)
{
  jdouble b = pop2(stack,index).d;
  jdouble a = pop2(stack,index).d;
  jdouble res = a-b;
  generic_t pushvar;
  if(res==0)
    pushvar.i = 0;
  else if(res>0)
    pushvar.i = 1;
  else
    pushvar.i = -1; //NaN will fall here
  push(stack,index,pushvar);
}

static inline void dcmpg(generic_t* stack, uint32_t* index)
{
  jdouble b = pop2(stack,index).d;
  jdouble a = pop2(stack,index).d;
  jdouble res = a-b;
  generic_t pushvar;
  if(res==0)
    pushvar.i = 0;
  else if(res<0)
    pushvar.i = -1;
  else
    pushvar.i = 1; //NaN will fall here
  push(stack,index,pushvar);
}

static inline void acmp(JNIEnv* env, generic_t* stack, uint32_t* index)
{
    jobject b = pop(stack,index).l;
    jobject a = pop(stack,index).l;
    generic_t res;
    res.i = (*env)->IsSameObject(env,a,b);
    push(stack,index,res);
}
