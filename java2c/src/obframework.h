#ifndef __OBFRAMEWORK_H__
#define __OBFRAMEWORK_H__

#include <stdint.h> //uint32_t
#include <stdio.h> //fprintf
#include <stdlib.h> //exit

typedef void* generic_t;

#define INVOKEVIRTUAL_ID_RESOLVER   jmethodID method_id;jclass caller_class = (*env)->FindClass(env, owner);if(caller_class == NULL){fprintf(stderr,"Class %s not found\n",owner);exit(EXIT_FAILURE);}method_id = (*env)->GetMethodID(env, caller_class, name, signature);if(method_id == NULL){fprintf(stderr,"Method %s not found\n",owner);exit(EXIT_FAILURE);}jobject class_instance = (jobject)pop(stack,index);

static inline void push(generic_t* stack, uint32_t* index, generic_t val)
{
    stack[(*index)++] = val;
}

static inline generic_t pop(generic_t* stack, uint32_t* index)
{
    return stack[--(*index)];
}

static inline void _IAdd(generic_t* stack, uint32_t* index)
{
    jint a = (jint)pop(stack,index);
    jint b = (jint)pop(stack,index);
    push(stack,index,(generic_t)(a+b));
}

static inline void _Load(generic_t* stack, generic_t* arg, uint32_t* index, int valueIndex)
{
    push(stack,index,arg[valueIndex]);
}

static inline void _InvokeVirtual_jint(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    INVOKEVIRTUAL_ID_RESOLVER
    generic_t res = (generic_t)(*env)->CallIntMethodA(env,class_instance,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeVirtual_jboolean(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    INVOKEVIRTUAL_ID_RESOLVER
    generic_t res = (generic_t)(*env)->CallBooleanMethodA(env,class_instance,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeVirtual_jbyte(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    INVOKEVIRTUAL_ID_RESOLVER
    generic_t res = (generic_t)(*env)->CallByteMethodA(env,class_instance,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeVirtual_jchar(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    INVOKEVIRTUAL_ID_RESOLVER
    generic_t res = (generic_t)(*env)->CallCharMethodA(env,class_instance,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeVirtual_jshort(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    INVOKEVIRTUAL_ID_RESOLVER
    generic_t res = (generic_t)(*env)->CallShortMethodA(env,class_instance,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeVirtual_jlong(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    INVOKEVIRTUAL_ID_RESOLVER
    generic_t res = (generic_t)(*env)->CallLongMethodA(env,class_instance,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeVirtual_jfloat(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    INVOKEVIRTUAL_ID_RESOLVER
    generic_t res = (generic_t)(uintptr_t)(*env)->CallFloatMethodA(env,class_instance,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeVirtual_jdouble(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    INVOKEVIRTUAL_ID_RESOLVER
    generic_t res = (generic_t)(uintptr_t)(*env)->CallDoubleMethodA(env,class_instance,method_id,values);
    push2(stack,index,res);
}

static inline void _InvokeVirtual_jobject(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    INVOKEVIRTUAL_ID_RESOLVER
    generic_t res = (generic_t)(*env)->CallObjectMethodA(env,class_instance,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeVirtual_void(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    INVOKEVIRTUAL_ID_RESOLVER
    (*env)->CallVoidMethodA(env,class_instance,method_id,values);
}

#define ARETURN return (jobject)pop(_stack,&index)
#define IRETURN return (jint)pop(_stack,&_index)
#define LRETURN return (jlong)pop(_stack,&_index)
#define FRETURN tmpdouble=pop(_stack,&_index);return *(jfloat*)&tmpdouble;
#define DRETURN tmpdouble=pop(_stack,&_index);return *(jdouble*)&tmpdouble;
#define VRETURN return
#endif
