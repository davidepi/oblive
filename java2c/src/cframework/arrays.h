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

static inline void _NewDoubleArray(JNIEnv* env, generic_t* stack, uint32_t* index)
{
  jint size = pop(stack,index).i;
  jdoubleArray array = (*env)->NewDoubleArray(env,size);
  OUT_OF_MEMORY_CHECK
  jdouble values[size];
  memset(values,0,size*sizeof(jdouble));//zero initialize array
  (*env)->SetDoubleArrayRegion(env, array, 0, size, values);
  generic_t res;
  res.l = array;
  push(stack,index,res);
}

static inline void _NewFloatArray(JNIEnv* env, generic_t* stack, uint32_t* index)
{
  jint size = pop(stack,index).i;
  jfloatArray array = (*env)->NewFloatArray(env,size);
  OUT_OF_MEMORY_CHECK
  jfloat values[size];
  memset(values,0,size*sizeof(jfloat));//zero initialize array
  (*env)->SetFloatArrayRegion(env, array, 0, size, values);
  generic_t res;
  res.l = array;
  push(stack,index,res);
}

static inline void _NewLongArray(JNIEnv* env, generic_t* stack, uint32_t* index)
{
  jint size = pop(stack,index).i;
  jlongArray array = (*env)->NewLongArray(env,size);
  OUT_OF_MEMORY_CHECK
  jlong values[size];
  memset(values,0,size*sizeof(jlong));//zero initialize array
  (*env)->SetLongArrayRegion(env, array, 0, size, values);
  generic_t res;
  res.l = array;
  push(stack,index,res);
}

static inline void _NewObjectArray(JNIEnv* env, generic_t* stack, uint32_t* index, const char* className)
{
  jint size = pop(stack,index).i;
  jclass caller_class = (*env)->FindClass(env, className);if(caller_class == NULL){fprintf(stderr,"Class %s not found\n",className);exit(EXIT_FAILURE);}
  jobjectArray array = (*env)->NewObjectArray(env,size,caller_class,0);
  OUT_OF_MEMORY_CHECK
  generic_t res;
  res.l = array;
  push(stack,index,res);
}

static inline void _Arraylength(JNIEnv* env, generic_t* stack, uint32_t* index)
{
  jarray array = pop(stack,index).l;
  generic_t res;
  res.i = (*env)->GetArrayLength(env,array);
  push(stack,index,res);
}

static inline void _IALoad(JNIEnv* env, generic_t* stack, uint32_t* index)
{
  jint array_index = pop(stack,index).i;
  jarray array = pop(stack,index).l;
  generic_t res;
  (*env)->GetIntArrayRegion(env,array,array_index,1,&(res.i));
  push(stack,index,res);
}

static inline void _LALoad(JNIEnv* env, generic_t* stack, uint32_t* index)
{
  jint array_index = pop(stack,index).i;
  jarray array = pop(stack,index).l;
  generic_t res;
  (*env)->GetLongArrayRegion(env,array,array_index,1,&(res.j));
  push2(stack,index,res);
}

static inline void _FALoad(JNIEnv* env, generic_t* stack, uint32_t* index)
{
  jint array_index = pop(stack,index).i;
  jarray array = pop(stack,index).l;
  generic_t res;
  (*env)->GetFloatArrayRegion(env,array,array_index,1,&(res.f));
  push(stack,index,res);
}

static inline void _DALoad(JNIEnv* env, generic_t* stack, uint32_t* index)
{
  jint array_index = pop(stack,index).i;
  jarray array = pop(stack,index).l;
  generic_t res;
  (*env)->GetDoubleArrayRegion(env,array,array_index,1,&(res.d));
  push2(stack,index,res);
}

static inline void _BALoad(JNIEnv* env, generic_t* stack, uint32_t* index)
{
  jint array_index = pop(stack,index).i;
  jarray array = pop(stack,index).l;
  generic_t res;
  (*env)->GetByteArrayRegion(env,array,array_index,1,&(res.b));
  push(stack,index,res);
}

static inline void _CALoad(JNIEnv* env, generic_t* stack, uint32_t* index)
{
  jint array_index = pop(stack,index).i;
  jarray array = pop(stack,index).l;
  generic_t res;
  (*env)->GetCharArrayRegion(env,array,array_index,1,&(res.c));
  push(stack,index,res);
}

static inline void _SALoad(JNIEnv* env, generic_t* stack, uint32_t* index)
{
  jint array_index = pop(stack,index).i;
  jarray array = pop(stack,index).l;
  generic_t res;
  (*env)->GetShortArrayRegion(env,array,array_index,1,&(res.s));
  push(stack,index,res);
}

static inline void _IAStore(JNIEnv* env, generic_t* stack, uint32_t* index)
{
  jint val = pop(stack,index).i;
  jint array_index = pop(stack,index).i;
  jarray array = pop(stack,index).l;
  (*env)->SetIntArrayRegion(env,array,array_index,1,&val);
}

static inline void _LAStore(JNIEnv* env, generic_t* stack, uint32_t* index)
{
  jlong val = pop2(stack,index).j;
  jint array_index = pop(stack,index).i;
  jarray array = pop(stack,index).l;
  (*env)->SetLongArrayRegion(env,array,array_index,1,&val);
}

static inline void _FAStore(JNIEnv* env, generic_t* stack, uint32_t* index)
{
  jfloat val = pop(stack,index).f;
  jint array_index = pop(stack,index).i;
  jarray array = pop(stack,index).l;
  (*env)->SetFloatArrayRegion(env,array,array_index,1,&val);
}

static inline void _DAStore(JNIEnv* env, generic_t* stack, uint32_t* index)
{
  jdouble val = pop2(stack,index).d;
  jint array_index = pop(stack,index).i;
  jarray array = pop(stack,index).l;
  (*env)->SetDoubleArrayRegion(env,array,array_index,1,&val);
}

static inline void _BAStore(JNIEnv* env, generic_t* stack, uint32_t* index)
{
  jbyte val = pop(stack,index).b;
  jint array_index = pop(stack,index).i;
  jarray array = pop(stack,index).l;
  (*env)->SetByteArrayRegion(env,array,array_index,1,&val);
}

static inline void _CAStore(JNIEnv* env, generic_t* stack, uint32_t* index)
{
  jchar val = pop(stack,index).c;
  jint array_index = pop(stack,index).i;
  jarray array = pop(stack,index).l;
  (*env)->SetCharArrayRegion(env,array,array_index,1,&val);
}

static inline void _SAStore(JNIEnv* env, generic_t* stack, uint32_t* index)
{
  jshort val = pop(stack,index).s;
  jint array_index = pop(stack,index).i;
  jarray array = pop(stack,index).l;
  (*env)->SetShortArrayRegion(env,array,array_index,1,&val);
}
