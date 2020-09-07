#include <string.h>
#define OUT_OF_MEMORY_CHECK if(array==NULL)fprintf(stderr,"Out of memory\n");
#define ARRAY_BODY(NAMECAPITAL,NAMENOCAPITAL) \
jint size = pop(socket, stack,index).i; \
if(size<0) return 1; \
j ## NAMENOCAPITAL ## Array array = (*env)->New ## NAMECAPITAL ## Array(env,size); \
OUT_OF_MEMORY_CHECK \
j ## NAMENOCAPITAL values[size]; \
memset(values,0,size*sizeof(j ## NAMENOCAPITAL ));\
(*env)->Set ## NAMECAPITAL ## ArrayRegion(env, array, 0, size, values);\
generic_t res;\
res.l = array;\
push(socket, stack,index,res);\
return 0;

static inline char _NewIntArray(int socket, JNIEnv* env, generic_t* stack, uint32_t* index)
{
  ARRAY_BODY(Int,int)
}

static inline char _NewBooleanArray(int socket, JNIEnv* env, generic_t* stack, uint32_t* index)
{
  ARRAY_BODY(Boolean,boolean)
}

static inline char _NewCharArray(int socket, JNIEnv* env, generic_t* stack, uint32_t* index)
{
  ARRAY_BODY(Char,char)
}

static inline char _NewByteArray(int socket, JNIEnv* env, generic_t* stack, uint32_t* index)
{
  ARRAY_BODY(Byte,byte)
}

static inline char _NewShortArray(int socket, JNIEnv* env, generic_t* stack, uint32_t* index)
{
  ARRAY_BODY(Short,short)
}

static inline char _NewDoubleArray(int socket, JNIEnv* env, generic_t* stack, uint32_t* index)
{
  ARRAY_BODY(Double,double)
}

static inline char _NewFloatArray(int socket, JNIEnv* env, generic_t* stack, uint32_t* index)
{
  ARRAY_BODY(Float,float)
}

static inline char _NewLongArray(int socket, JNIEnv* env, generic_t* stack, uint32_t* index)
{
  ARRAY_BODY(Long,long)
}

static inline char _NewObjectArray(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* className)
{
  jint size = pop(socket, stack,index).i;
  if(size<0)
    return 1;
  jclass caller_class = (*env)->FindClass(env, className);if(caller_class == NULL){fprintf(stderr,"Class %s not found\n",className);exit(EXIT_FAILURE);}
  jobjectArray array = (*env)->NewObjectArray(env,size,caller_class,0);
  OUT_OF_MEMORY_CHECK
  generic_t res;
  res.l = array;
  push(socket, stack,index,res);
  return 0;
}

static inline char _Arraylength(int socket, JNIEnv* env, generic_t* stack, uint32_t* index)
{
  jarray array = pop(socket,stack,index).l;
  if(array == NULL)
    return 1;
  generic_t res;
  res.i = (*env)->GetArrayLength(env,array);
  push(socket,stack,index,res);
  return 0;
}

//FOR LOAD AND STORE
//retval codes:
//  0 - No exceptions
//  1 - ArrayIndexOutOfBoundsException
//  2 - NullPointerException
//  3 - ArrayStoreException 
static inline char _IALoad(int socket, JNIEnv* env, generic_t* stack, uint32_t* index)
{
  char retval = 0;
  jint array_index = pop(socket,stack,index).i;
  jarray array = pop(socket,stack,index).l;
  if(array==NULL)
    retval = 2;
  else if(array_index>=0 && array_index<(*env)->GetArrayLength(env,array))
  {
    generic_t res;
    (*env)->GetIntArrayRegion(env,array,array_index,1,&(res.i));
    push(socket,stack,index,res);
  }
  else
    retval = 1;
  return retval;
}

static inline char _LALoad(int socket, JNIEnv* env, generic_t* stack, uint32_t* index)
{
  char retval = 0;
  jint array_index = pop(socket,stack,index).i;
  jarray array = pop(socket,stack,index).l;
  if(array==NULL)
    retval = 2;
  else if(array_index>=0 && array_index<(*env)->GetArrayLength(env,array))
  {
    generic_t res;
    (*env)->GetLongArrayRegion(env,array,array_index,1,&(res.j));
    push2(socket,stack,index,res);
  }
  else
    retval = 1;
  return retval;
}

static inline char _FALoad(int socket, JNIEnv* env, generic_t* stack, uint32_t* index)
{
  char retval = 0;
  jint array_index = pop(socket,stack,index).i;
  jarray array = pop(socket,stack,index).l;
  if(array==NULL)
    retval = 2;
  else if(array_index>=0 && array_index<(*env)->GetArrayLength(env,array))
  {
    generic_t res;
    (*env)->GetFloatArrayRegion(env,array,array_index,1,&(res.f));
    push(socket,stack,index,res);
  }
  else
    retval = 1;
  return retval;
}

static inline char _DALoad(int socket, JNIEnv* env, generic_t* stack, uint32_t* index)
{
  char retval = 0;
  jint array_index = pop(socket,stack,index).i;
  jarray array = pop(socket,stack,index).l;
  if(array==NULL)
    retval = 2;
  else if(array_index>=0 && array_index<(*env)->GetArrayLength(env,array))
  {
    generic_t res;
    (*env)->GetDoubleArrayRegion(env,array,array_index,1,&(res.d));
    push2(socket,stack,index,res);
  }
  else
    retval = 1;
  return retval;
}

static inline char _AALoad(int socket, JNIEnv* env, generic_t* stack, uint32_t* index)
{
  char retval = 0;
  jint array_index = pop(socket,stack,index).i;
  jarray array = pop(socket,stack,index).l;
  if(array==NULL)
    retval = 2;
  else if(array_index>=0 && array_index<(*env)->GetArrayLength(env,array))
  {
    generic_t res;
    res.l = (*env)->GetObjectArrayElement(env,array,array_index);
    push(socket,stack,index,res);
  }
  else
    retval = 1;
  return retval;
}

static inline char _BALoad(int socket, JNIEnv* env, generic_t* stack, uint32_t* index)
{
  char retval = 0;
  jint array_index = pop(socket,stack,index).i;
  jarray array = pop(socket,stack,index).l;
  if(array==NULL)
    retval = 2;
  else if(array_index>=0 && array_index<(*env)->GetArrayLength(env,array))
  {
    generic_t res;
    (*env)->GetByteArrayRegion(env,array,array_index,1,&(res.b));
    push(socket,stack,index,res);
  }
  else
    retval = 1;
  return retval;
}

static inline char _CALoad(int socket, JNIEnv* env, generic_t* stack, uint32_t* index)
{
  char retval = 0;
  jint array_index = pop(socket,stack,index).i;
  jarray array = pop(socket,stack,index).l;
  if(array==NULL)
    retval = 2;
  else if(array_index>=0 && array_index<(*env)->GetArrayLength(env,array))
  {
    generic_t res;
    (*env)->GetCharArrayRegion(env,array,array_index,1,&(res.c));
    push(socket,stack,index,res);
  }
  else
    retval = 1;
  return retval;
}

static inline char _SALoad(int socket, JNIEnv* env, generic_t* stack, uint32_t* index)
{
  char retval = 0;
  jint array_index = pop(socket,stack,index).i;
  jarray array = pop(socket,stack,index).l;
  if(array==NULL)
    retval = 2;
  else if(array_index>=0 && array_index<(*env)->GetArrayLength(env,array))
  {
    generic_t res;
    (*env)->GetShortArrayRegion(env,array,array_index,1,&(res.s));
    push(socket,stack,index,res);
  }
  else
    retval = 1;
  return retval;
}

static inline char _IAStore(int socket,JNIEnv* env, generic_t* stack, uint32_t* index)
{
  char retval = 0;
  jint val = pop(socket,stack,index).i;
  jint array_index = pop(socket,stack,index).i;
  jarray array = pop(socket,stack,index).l;
  if(array==NULL)
    retval = 2;
  else if(array_index>=0 && array_index<(*env)->GetArrayLength(env,array))
    (*env)->SetIntArrayRegion(env,array,array_index,1,&val);
  else
    retval = 1;
  return retval;
}

static inline char _LAStore(int socket, JNIEnv* env, generic_t* stack, uint32_t* index)
{
  char retval = 0;
  jlong val = pop2(socket,stack,index).j;
  jint array_index = pop(socket,stack,index).i;
  jarray array = pop(socket,stack,index).l;
  if(array==NULL)
    retval = 2;
  else if(array_index>=0 && array_index<(*env)->GetArrayLength(env,array))
    (*env)->SetLongArrayRegion(env,array,array_index,1,&val);
  else
    retval = 1;
  return retval;
}

static inline char _FAStore(int socket, JNIEnv* env, generic_t* stack, uint32_t* index)
{
  char retval = 0;
  jfloat val = pop(socket,stack,index).f;
  jint array_index = pop(socket,stack,index).i;
  jarray array = pop(socket,stack,index).l;
  if(array==NULL)
    retval = 2;
  else if(array_index>=0 && array_index<(*env)->GetArrayLength(env,array))
    (*env)->SetFloatArrayRegion(env,array,array_index,1,&val);
  else
    retval = 1;
  return retval;
}

static inline char _DAStore(int socket, JNIEnv* env, generic_t* stack, uint32_t* index)
{
  char retval = 0;
  jdouble val = pop2(socket,stack,index).d;
  jint array_index = pop(socket,stack,index).i;
  jarray array = pop(socket,stack,index).l;
  if(array==NULL)
    retval = 2;
  else if(array_index>=0 && array_index<(*env)->GetArrayLength(env,array))
    (*env)->SetDoubleArrayRegion(env,array,array_index,1,&val);
  else
    retval = 1;
  return retval;
}

static inline char _BAStore(int socket, JNIEnv* env, generic_t* stack, uint32_t* index)
{
  char retval = 0;
  jbyte val = pop(socket,stack,index).b;
  jint array_index = pop(socket,stack,index).i;
  jarray array = pop(socket,stack,index).l;
  if(array==NULL)
    retval = 2;
  else if(array_index>=0 && array_index<(*env)->GetArrayLength(env,array))
    (*env)->SetByteArrayRegion(env,array,array_index,1,&val);
  else
    retval = 1;
  return retval;
}

static inline char _CAStore(int socket, JNIEnv* env, generic_t* stack, uint32_t* index)
{
  char retval = 0;
  jchar val = pop(socket,stack,index).c;
  jint array_index = pop(socket,stack,index).i;
  jarray array = pop(socket,stack,index).l;
  if(array==NULL)
    retval = 2;
  else if(array_index>=0 && array_index<(*env)->GetArrayLength(env,array))
    (*env)->SetCharArrayRegion(env,array,array_index,1,&val);
  else
    retval = 1;
  return retval;
}

static inline char _SAStore(int socket, JNIEnv* env, generic_t* stack, uint32_t* index)
{
  char retval = 0;
  jshort val = pop(socket,stack,index).s;
  jint array_index = pop(socket,stack,index).i;
  jarray array = pop(socket,stack,index).l;
  if(array==NULL)
    retval = 2;
  else if(array_index>=0 && array_index<(*env)->GetArrayLength(env,array))
    (*env)->SetShortArrayRegion(env,array,array_index,1,&val);
  else
    retval = 1;
  return retval;
}

static inline char _AAStore(int socket, JNIEnv* env, generic_t* stack, uint32_t* index)
{
  char retval = 0;
  jobject val = pop(socket,stack,index).l;
  jint array_index = pop(socket,stack,index).i;
  jarray array = pop(socket,stack,index).l;
  if(array==NULL)
    retval = 2;
  else if(array_index>=0 && array_index<(*env)->GetArrayLength(env,array))
  {
    (*env)->SetObjectArrayElement(env,array,array_index,val);
    if((*env)->ExceptionCheck(env))
    {
      (*env)->ExceptionClear(env);
      retval = 3;
    }
  }
  else
    retval = 1;
  return retval;
}
