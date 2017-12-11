#ifndef __OBFRAMEWORK_H__
#define __OBFRAMEWORK_H__

#include <stdint.h> //uint32_t

static inline void push(void** stack, uint32_t* index, void* val)
{
    stack[(*index)++] = val;
}

static inline void* pop(void** stack, uint32_t* index)
{
    return stack[--(*index)];
}

static inline void _IAdd(void** stack, uint32_t* index)
{
    jint a = (jint)pop(stack,index);
    jint b = (jint)pop(stack,index);
    push(stack,index,(void*)(uintptr_t)(a+b));
}

static inline void _ILoad(void** stack, void** arg, uint32_t* index, int value)
{
    push(stack,index,arg[value]);
}

#define IRETURN return (jint)pop(_stack,&_index)

#endif
