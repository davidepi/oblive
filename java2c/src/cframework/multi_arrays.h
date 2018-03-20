#define MULTIDIMENSIONAL_RECURSION_BODY(NAMECAPITAL,NAMENOCAPITAL) jobject array;                        \
  if(current_dimension>0){ \
    jclass caller_class = (*env)->FindClass(env, className);if(caller_class == NULL){fprintf(stderr,"Class %s not found\n",className);exit(EXIT_FAILURE);} \
    array = (*env)->NewObjectArray(env,dimslen[current_dimension],caller_class,0);\
    OUT_OF_MEMORY_CHECK \
    for(int i=0;i<dimslen[current_dimension];i++)\
    (*env)->SetObjectArrayElement(env,array,i,multidimarray_ ## NAMENOCAPITAL ## _rec(env,dimslen,current_dimension-1,className+1));\
  }\
  else{\
    int size = *dimslen;\
    array = (*env)->New ## NAMECAPITAL ## Array(env,size);\
    j ## NAMENOCAPITAL values[size];\
    memset(values,0,size*sizeof(j ## NAMENOCAPITAL ));\
    (*env)->Set ## NAMECAPITAL ## ArrayRegion(env, array, 0, dimslen[current_dimension], values);\
  }\
  return array;

#define MULTIDIMENSIONAL_MAIN_BODY(TYPE) int dimslen[dimensions]; /*dimensions is known at compile time*/\
  for(int i=0;i<dimensions;i++) /*pushed in reverse order, so I can know when to stop*/\
    dimslen[i] = pop(stack,index).i;\
  generic_t res;\
  res.l = multidimarray_ ## TYPE ## _rec(env,dimslen,dimensions-1,className+1); /* Recursive step */\
  push(stack,index,res);\

static inline jobject multidimarray_object_rec(JNIEnv* env, const int* dimslen, int current_dimension, const char* className) //the only different one
{
  jobject array;
  if(current_dimension>0)
  {
    jclass caller_class = (*env)->FindClass(env, className);if(caller_class == NULL){fprintf(stderr,"Class %s not found\n",className);exit(EXIT_FAILURE);}
    array = (*env)->NewObjectArray(env,dimslen[current_dimension],caller_class,0);
    OUT_OF_MEMORY_CHECK
    for(int i=0;i<dimslen[current_dimension];i++)
    (*env)->SetObjectArrayElement(env,array,i,multidimarray_object_rec(env,dimslen,current_dimension-1,className+1));
  }
  else{
    int size = *dimslen;
    jclass caller_class = (*env)->FindClass(env, className);if(caller_class == NULL){fprintf(stderr,"Class %s not found\n",className);exit(EXIT_FAILURE);}
    array = (*env)->NewObjectArray(env,size,caller_class,0);
    OUT_OF_MEMORY_CHECK
  }
  return array;
}

static inline jobject multidimarray_int_rec(JNIEnv* env, const int* dimslen, int current_dimension, const char* className)
{
  MULTIDIMENSIONAL_RECURSION_BODY(Int,int)
}

static inline jobject multidimarray_float_rec(JNIEnv* env, const int* dimslen, int current_dimension, const char* className)
{
  MULTIDIMENSIONAL_RECURSION_BODY(Float,float)
}

static inline jobject multidimarray_double_rec(JNIEnv* env, const int* dimslen, int current_dimension, const char* className)
{
  MULTIDIMENSIONAL_RECURSION_BODY(Double,double)
}

static inline jobject multidimarray_char_rec(JNIEnv* env, const int* dimslen, int current_dimension, const char* className)
{
  MULTIDIMENSIONAL_RECURSION_BODY(Char,char)
}

static inline jobject multidimarray_byte_rec(JNIEnv* env, const int* dimslen, int current_dimension, const char* className)
{
  MULTIDIMENSIONAL_RECURSION_BODY(Byte,byte)
}

static inline jobject multidimarray_boolean_rec(JNIEnv* env, const int* dimslen, int current_dimension, const char* className)
{
  MULTIDIMENSIONAL_RECURSION_BODY(Boolean,boolean)
}

static inline jobject multidimarray_long_rec(JNIEnv* env, const int* dimslen, int current_dimension, const char* className)
{
  MULTIDIMENSIONAL_RECURSION_BODY(Long,long)
}

static inline jobject multidimarray_short_rec(JNIEnv* env, const int* dimslen, int current_dimension, const char* className)
{
  MULTIDIMENSIONAL_RECURSION_BODY(Short,short)
}

static inline void _NewMultidimensionalIntArray(JNIEnv* env, generic_t* stack, uint32_t* index, const char* className, int dimensions)
{
  MULTIDIMENSIONAL_MAIN_BODY(int)
}

static inline void _NewMultidimensionalFloatArray(JNIEnv* env, generic_t* stack, uint32_t* index, const char* className, int dimensions)
{
  MULTIDIMENSIONAL_MAIN_BODY(float)
}

static inline void _NewMultidimensionalByteArray(JNIEnv* env, generic_t* stack, uint32_t* index, const char* className, int dimensions)
{
  MULTIDIMENSIONAL_MAIN_BODY(byte)
}

static inline void _NewMultidimensionalBooleanArray(JNIEnv* env, generic_t* stack, uint32_t* index, const char* className, int dimensions)
{
  MULTIDIMENSIONAL_MAIN_BODY(boolean)
}

static inline void _NewMultidimensionalCharArray(JNIEnv* env, generic_t* stack, uint32_t* index, const char* className, int dimensions)
{
  MULTIDIMENSIONAL_MAIN_BODY(char)
}

static inline void _NewMultidimensionalShortArray(JNIEnv* env, generic_t* stack, uint32_t* index, const char* className, int dimensions)
{
  MULTIDIMENSIONAL_MAIN_BODY(short)
}

static inline void _NewMultidimensionalLongArray(JNIEnv* env, generic_t* stack, uint32_t* index, const char* className, int dimensions)
{
  MULTIDIMENSIONAL_MAIN_BODY(long)
}

static inline void _NewMultidimensionalDoubleArray(JNIEnv* env, generic_t* stack, uint32_t* index, const char* className, int dimensions)
{
  MULTIDIMENSIONAL_MAIN_BODY(double)
}

static inline void _NewMultidimensionalObjectArray(JNIEnv* env, generic_t* stack, uint32_t* index, const char* className, int dimensions)
{
  MULTIDIMENSIONAL_MAIN_BODY(object)
}
