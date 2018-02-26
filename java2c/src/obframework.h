#ifndef __OBFRAMEWORK_H__
#define __OBFRAMEWORK_H__

#include <stdint.h> //uint32_t
#include <stdio.h> //fprintf
#include <stdlib.h> //exit

typedef jvalue generic_t;

#define INVOKEVIRTUAL_ID_RESOLVER   jmethodID method_id;jclass caller_class = (*env)->FindClass(env, owner);if(caller_class == NULL){fprintf(stderr,"Class %s not found\n",owner);exit(EXIT_FAILURE);}method_id = (*env)->GetMethodID(env, caller_class, name, signature);if(method_id == NULL){fprintf(stderr,"Method %s not found\n",owner);exit(EXIT_FAILURE);}jobject class_instance = pop(stack,index).l;

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

static inline void _InvokeVirtual_jint(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    INVOKEVIRTUAL_ID_RESOLVER
    generic_t res;
    res.i = (*env)->CallIntMethodA(env,class_instance,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeVirtual_jboolean(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    INVOKEVIRTUAL_ID_RESOLVER
    generic_t res;
    res.z = (*env)->CallBooleanMethodA(env,class_instance,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeVirtual_jbyte(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    INVOKEVIRTUAL_ID_RESOLVER
    generic_t res;
    res.b = (*env)->CallByteMethodA(env,class_instance,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeVirtual_jchar(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    INVOKEVIRTUAL_ID_RESOLVER
    generic_t res;
    res.c = (*env)->CallCharMethodA(env,class_instance,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeVirtual_jshort(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    INVOKEVIRTUAL_ID_RESOLVER
    generic_t res;
    res.s = (*env)->CallShortMethodA(env,class_instance,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeVirtual_jlong(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    INVOKEVIRTUAL_ID_RESOLVER
    generic_t res;
    res.j = (*env)->CallLongMethodA(env,class_instance,method_id,values);
    push2(stack,index,res);
}

static inline void _InvokeVirtual_jfloat(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    INVOKEVIRTUAL_ID_RESOLVER
    generic_t res;
    res.f = (*env)->CallFloatMethodA(env,class_instance,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeVirtual_jdouble(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    INVOKEVIRTUAL_ID_RESOLVER
    generic_t res;
    res.d = (*env)->CallDoubleMethodA(env,class_instance,method_id,values);
    push2(stack,index,res);
}

static inline void _InvokeVirtual_jobject(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    INVOKEVIRTUAL_ID_RESOLVER
    generic_t res;
    res.l = (*env)->CallObjectMethodA(env,class_instance,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeVirtual_void(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    INVOKEVIRTUAL_ID_RESOLVER
    (*env)->CallVoidMethodA(env,class_instance,method_id,values);
}

#define ARETURN {jvalue __areturn_retval__ = pop(_stack,&_index); return __areturn_retval__.l;}
#define IRETURN {jvalue __ireturn_retval__ = pop(_stack,&_index); return __ireturn_retval__.i;}
#define LRETURN {jvalue __lreturn_retval__ = pop2(_stack,&_index); return __lreturn_retval__.j;}
#define FRETURN {jvalue __freturn_retval__ = pop(_stack,&_index); return __freturn_retval__.f;}
#define DRETURN {jvalue __dreturn_retval__ = pop2(_stack,&_index); return __dreturn_retval__.d;}
#define VRETURN {return;}
#endif
