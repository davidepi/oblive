static inline void push(generic_t* stack, uint32_t* index, generic_t val)
{
    stack[(*index)++] = val;
}

static inline void push2(generic_t* stack, uint32_t* index, generic_t val)
{
  stack[(*index)++] = val;
  (*index)++;
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

static inline void _IAdd(generic_t* stack, uint32_t* index)
{
    jint a = pop(stack,index).i;
    jint b = pop(stack,index).i;
    generic_t res;
    res.i = a+b;
    push(stack,index,res);
}

static inline void _Load(generic_t* stack, generic_t* arg, uint32_t* index, int valueIndex)
{
    push(stack,index,arg[valueIndex]);
}

static inline void _Load2(generic_t* stack, generic_t* arg, uint32_t* index, int valueIndex)
{
    push2(stack,index,arg[valueIndex]);
}

#define ARETURN {jvalue __areturn_retval__ = pop(_stack,&_index); return __areturn_retval__.l;}
#define IRETURN {jvalue __ireturn_retval__ = pop(_stack,&_index); return __ireturn_retval__.i;}
#define LRETURN {jvalue __lreturn_retval__ = pop2(_stack,&_index); return __lreturn_retval__.j;}
#define FRETURN {jvalue __freturn_retval__ = pop(_stack,&_index); return __freturn_retval__.f;}
#define DRETURN {jvalue __dreturn_retval__ = pop2(_stack,&_index); return __dreturn_retval__.d;}
#define VRETURN {return;}

