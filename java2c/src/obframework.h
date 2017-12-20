#ifndef __OBFRAMEWORK_H__
#define __OBFRAMEWORK_H__

#include <stdint.h> //uint32_t
#include <stdio.h> //fprintf
#include <stdlib.h> //exit

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

static inline void _ALoad(void** stack, void** arg, uint32_t* index, int value)
{
    push(stack,index,arg[value]);
}

static inline void _InvokeVirtual_int(JNIEnv* env, void** stack, uint32_t* index, const char* owner, const char* name, const char* signature)
{
    jmethodID method_id;
    jclass caller_class = (*env)->FindClass(env, owner);
    if(caller_class == NULL)
    {
        fprintf(stderr,"Class %s not found\n",owner);
        exit(EXIT_FAILURE);
    }
    method_id = (*env)->GetMethodID(env, caller_class, name, signature);
    if(method_id == NULL)
    {

        fprintf(stderr,"Method %s not found\n",owner);
        exit(EXIT_FAILURE);
    }

    jvalue args[2]; //in the transformed .c
    for(int i=1;i>=0;i--)
        args[i].i = (jint)pop(stack,index);

    jobject class_instance = pop(stack,index);
    void* res = (void*)(uintptr_t)(*env)->CallIntMethodA(env,class_instance,method_id,args);
    push(stack,index,res);
}

#define IRETURN return (jint)pop(_stack,&_index)

#endif
