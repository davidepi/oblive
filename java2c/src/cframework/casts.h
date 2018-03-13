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
  res.j = (jint)pop2(stack,index).j;
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

