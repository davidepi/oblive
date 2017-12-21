#ifndef __OBFRAMEWORK_H__
#define __OBFRAMEWORK_H__
#define INVOKEVIRTUAL_ID_RESOLVER   jmethodID method_id;jclass caller_class = (*env)->FindClass(env, owner);if(caller_class == NULL){fprintf(stderr,"Class %s not found\n",owner);exit(EXIT_FAILURE);}method_id = (*env)->GetMethodID(env, caller_class, name, signature);if(method_id == NULL){fprintf(stderr,"Method %s not found\n",owner);exit(EXIT_FAILURE);}

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

static inline void _Load(void** stack, void** arg, uint32_t* index, int valueIndex)
{
    push(stack,index,arg[valueIndex]);
}

static inline void _InvokeVirtual_jint(JNIEnv* env, void** stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    INVOKEVIRTUAL_ID_RESOLVER
    jobject class_instance = pop(stack,index);
    void* res = (void*)(uintptr_t)(*env)->CallIntMethodA(env,class_instance,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeVirtual_jboolean(JNIEnv* env, void** stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    INVOKEVIRTUAL_ID_RESOLVER
    jobject class_instance = pop(stack,index);
    void* res = (void*)(uintptr_t)(*env)->CallBooleanMethodA(env,class_instance,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeVirtual_jbyte(JNIEnv* env, void** stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    INVOKEVIRTUAL_ID_RESOLVER
    jobject class_instance = pop(stack,index);
    void* res = (void*)(uintptr_t)(*env)->CallByteMethodA(env,class_instance,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeVirtual_jchar(JNIEnv* env, void** stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    INVOKEVIRTUAL_ID_RESOLVER
    jobject class_instance = pop(stack,index);
    void* res = (void*)(uintptr_t)(*env)->CallCharMethodA(env,class_instance,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeVirtual_jshort(JNIEnv* env, void** stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    INVOKEVIRTUAL_ID_RESOLVER
    jobject class_instance = pop(stack,index);
    void* res = (void*)(uintptr_t)(*env)->CallShortMethodA(env,class_instance,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeVirtual_jlong(JNIEnv* env, void** stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    INVOKEVIRTUAL_ID_RESOLVER
    jobject class_instance = pop(stack,index);
    void* res = (void*)(uintptr_t)(*env)->CallLongMethodA(env,class_instance,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeVirtual_jfloat(JNIEnv* env, void** stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    INVOKEVIRTUAL_ID_RESOLVER
    jobject class_instance = pop(stack,index);
    void* res = (void*)(uintptr_t)(*env)->CallFloatMethodA(env,class_instance,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeVirtual_jdouble(JNIEnv* env, void** stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    INVOKEVIRTUAL_ID_RESOLVER
    jobject class_instance = pop(stack,index);
    void* res = (void*)(uintptr_t)(*env)->CallDoubleMethodA(env,class_instance,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeVirtual_jobject(JNIEnv* env, void** stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    INVOKEVIRTUAL_ID_RESOLVER
    jobject class_instance = pop(stack,index);
    void* res = (void*)(uintptr_t)(*env)->CallObjectMethodA(env,class_instance,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeVirtual_void(JNIEnv* env, void** stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    INVOKEVIRTUAL_ID_RESOLVER
    jobject class_instance = pop(stack,index);
    (*env)->CallObjectMethodA(env,class_instance,method_id,values);
}

#define ARETURN return (jobject)pop(_stack,&index)
#define IRETURN return (jint)pop(_stack,&_index)
#define LRETURN return (jlong)pop(_stack,&_index)
#define FRETURN return (jfloat)pop(_stack,&_index)
#define DRETURN tmpdouble=pop(_stack,&_index);return *(jdouble*)&tmpdouble;
#define VRETURN return
#endif
