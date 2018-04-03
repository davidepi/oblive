#define INIT_METHOD_ID_RESOLVER   jmethodID method_id;jclass constructed_class = (*env)->FindClass(env, class_name);if(constructed_class == NULL){fprintf(stderr,"Class %s not found\n",class_name);exit(EXIT_FAILURE);}method_id = (*env)->GetMethodID(env, constructed_class, "<init>", signature);if(method_id == NULL){fprintf(stderr,"Method <init> not found in class %s\n",class_name);exit(EXIT_FAILURE);}

static inline void _New(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* signature, jvalue* values)
{
    INIT_METHOD_ID_RESOLVER
    generic_t res;
    res.l = (*env)->NewObjectA(env,constructed_class,method_id,values);
    push(stack,index,res);
}

static inline char _Throw(JNIEnv* env, generic_t* stack, uint32_t* index)
{
  char retval;
  generic_t throwable = pop(stack,index);
  if(throwable.l == NULL)
  {
    retval = 1;
  }
  else
  {
    *index = 0;
    push(stack,index,throwable);
    (*env)->Throw(env,throwable.l);
    retval = 0;
  }
  return retval;
}

