#define INIT_METHOD_ID_RESOLVER   jmethodID method_id;jclass constructed_class = (*env)->FindClass(env, class_name);if(constructed_class == NULL){fprintf(stderr,"Class %s not found\n",class_name);exit(EXIT_FAILURE);}method_id = (*env)->GetMethodID(env, constructed_class, "<init>", signature);if(method_id == NULL){fprintf(stderr,"Method <init> not found in class %s\n",class_name);exit(EXIT_FAILURE);}

static inline void _New(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* signature, jvalue* values)
{
    INIT_METHOD_ID_RESOLVER
    generic_t res;
    res.l = (*env)->NewObjectA(env,constructed_class,method_id,values);
    push(socket, stack,index,res);
}

//exception is created from the JNI layer
static inline void _ThrowFromJNI(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* exception_name)
{
#ifdef SELF_DEBUG
    run_command(socket, CLR);
#else
  *index = 0;
#endif
  jclass constructed_class = (*env)->FindClass(env,exception_name);
  jmethodID method_id = (*env)->GetMethodID(env,constructed_class,"<init>","()V");
  generic_t res;
  res.l = (*env)->NewObject(env,constructed_class,method_id,NULL);
  push(socket, stack,index,res);
}

//exception is created from the user
static inline char _ThrowFromUser(int socket, JNIEnv* nev, generic_t* stack, uint32_t* index)
{
  char retval = 0;
  generic_t res = pop(socket,stack,index);
  if(res.l!=NULL)
  {
    #ifdef SELF_DEBUG
        run_command(socket, CLR);
    #else
      *index = 0;
    #endif
    push(socket,stack,index,res);
  }
  else
    retval = 1;
  return retval;
}

//exception is created from the JVM
static inline void _ThrowFromJVM(int socket,JNIEnv* env, generic_t* stack, uint32_t* index)
{
  #ifdef SELF_DEBUG
      run_command(socket, CLR);
  #else
    *index = 0;
  #endif
  generic_t res;
  res.l = (*env)->ExceptionOccurred(env);
  push(socket,stack,index,res);
}

//exception is handled to the JVM for resolution
static inline void _ThrowBack(int socket, JNIEnv* env, generic_t* stack, uint32_t* index) {
    generic_t res = pop(socket, stack, index);
    (*env)->Throw(env,res.l);
}
