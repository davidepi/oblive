#define INIT_METHOD_ID_RESOLVER   jmethodID method_id;jclass constructed_class = (*env)->FindClass(env, class_name);if(constructed_class == NULL){fprintf(stderr,"Class %s not found\n",class_name);exit(EXIT_FAILURE);}method_id = (*env)->GetMethodID(env, constructed_class, "<init>", signature);if(method_id == NULL){fprintf(stderr,"Method <init> not found in class %s\n",class_name);exit(EXIT_FAILURE);}

static inline void _New(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* signature, jvalue* values)
{
    INIT_METHOD_ID_RESOLVER
    generic_t res;
    res.l = (*env)->NewObjectA(env,constructed_class,method_id,values);
    push(stack,index,res);
}

//exception is created from the JNI layer
static inline void _ThrowFromJNI(JNIEnv* env, generic_t* stack, uint32_t* index, const char* exception_name)
{
  *index = 0;
  jclass constructed_class = (*env)->FindClass(env,exception_name);
  jmethodID method_id = (*env)->GetMethodID(env,constructed_class,"<init>","()V");
  generic_t res;
  res.l = (*env)->NewObject(env,constructed_class,method_id,NULL);
  push(stack,index,res);
}

//exception is created from the user
static inline char _ThrowFromUser(JNIEnv* nev, generic_t* stack, uint32_t* index)
{
  char retval = 0;
  generic_t res = pop(stack,index);
  if(res.l!=NULL)
  {
    *index = 0;
    push(stack,index,res);
  }
  else
    retval = 1;
  return retval;
}

//exception is created from the JVM
static inline void _ThrowFromJVM(JNIEnv* env, generic_t* stack, uint32_t* index)
{
  *index = 0;
  generic_t res;
  res.l = (*env)->ExceptionOccurred(env);
  push(stack,index,res);
}
