#include <string.h>
#define OUT_OF_MEMORY_CHECK if(array==NULL)fprintf(stderr,"Out of memory\n");
static inline void _NewIntArray(JNIEnv* env, generic_t* stack, uint32_t* index)
{
  jint size = pop(stack,index).i;
  jintArray array = (*env)->NewIntArray(env,size);
  OUT_OF_MEMORY_CHECK
  jint values[size];
  memset(values,0,size*sizeof(jint));//zero initialize array
  (*env)->SetIntArrayRegion(env, array, 0, size, values);
  generic_t res;
  res.l = array;
  push(stack,index,res);
}

static inline void _NewBooleanArray(JNIEnv* env, generic_t* stack, uint32_t* index)
{
  jint size = pop(stack,index).i;
  jbooleanArray array = (*env)->NewBooleanArray(env,size);
  OUT_OF_MEMORY_CHECK
  jboolean values[size];
  memset(values,0,size*sizeof(jboolean));//zero initialize array
  (*env)->SetBooleanArrayRegion(env, array, 0, size, values);
  generic_t res;
  res.l = array;
  push(stack,index,res);
}

static inline void _NewCharArray(JNIEnv* env, generic_t* stack, uint32_t* index)
{
  jint size = pop(stack,index).i;
  jcharArray array = (*env)->NewCharArray(env,size);
  OUT_OF_MEMORY_CHECK
  jchar values[size];
  memset(values,0,size*sizeof(jchar));//zero initialize array
  (*env)->SetCharArrayRegion(env, array, 0, size, values);
  generic_t res;
  res.l = array;
  push(stack,index,res);
}

static inline void _NewByteArray(JNIEnv* env, generic_t* stack, uint32_t* index)
{
  jint size = pop(stack,index).i;
  jbyteArray array = (*env)->NewByteArray(env,size);
  OUT_OF_MEMORY_CHECK
  jbyte values[size];
  memset(values,0,size*sizeof(jbyte));//zero initialize array
  (*env)->SetByteArrayRegion(env, array, 0, size, values);
  generic_t res;
  res.l = array;
  push(stack,index,res);
}

static inline void _NewShortArray(JNIEnv* env, generic_t* stack, uint32_t* index)
{
  jint size = pop(stack,index).i;
  jshortArray array = (*env)->NewShortArray(env,size);
  OUT_OF_MEMORY_CHECK
  jshort values[size];
  memset(values,0,size*sizeof(jshort));//zero initialize array
  (*env)->SetShortArrayRegion(env, array, 0, size, values);
  generic_t res;
  res.l = array;
  push(stack,index,res);
}
