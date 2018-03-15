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
