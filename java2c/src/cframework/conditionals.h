static inline void lcmp(generic_t* stack, uint32_t* index)
{
    jlong b = pop2(stack,index).j;
    jlong a = pop2(stack,index).j;
    generic_t res;
    res.j = a-b;
    push(stack,index,res);
}

static inline void fcmpl(generic_t* stack, uint32_t* index)
{
  jfloat b = pop(stack,index).f;
  jfloat a = pop(stack,index).f;
  jfloat res = a-b;
  generic_t pushvar;
  if(res!=res || res<0)
    pushvar.i = -1;
  else if(res>0)
    pushvar.i = 1;
  else
    pushvar.i = 0;
  push(stack,index,pushvar);
}

static inline void fcmpg(generic_t* stack, uint32_t* index)
{
  jfloat b = pop(stack,index).f;
  jfloat a = pop(stack,index).f;
  jfloat res = a-b;
  generic_t pushvar;
  if(res!=res || res>0)
    pushvar.i = 1;
  else if(res<0)
    pushvar.i = -1;
  else
    pushvar.i = 0;
  push(stack,index,pushvar);
}

static inline void dcmpl(generic_t* stack, uint32_t* index)
{
  jdouble b = pop2(stack,index).d;
  jdouble a = pop2(stack,index).d;
  jdouble res = a-b;
  generic_t pushvar;
  if(res!=res || res<0)
    pushvar.i = -1;
  else if(res>0)
    pushvar.i = 1;
  else
    pushvar.i = 0;
  push(stack,index,pushvar);
}

static inline void dcmpg(generic_t* stack, uint32_t* index)
{
  jdouble b = pop2(stack,index).d;
  jdouble a = pop2(stack,index).d;
  jdouble res = a-b;
  generic_t pushvar;
  if(res!=res || res>0)
    pushvar.i = 1;
  else if(res<0)
    pushvar.i = -1;
  else
    pushvar.i = 0;
  push(stack,index,pushvar);
}
