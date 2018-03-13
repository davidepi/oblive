#define INIT_METHOD_ID_RESOLVER   jmethodID method_id;jclass constructed_class = (*env)->FindClass(env, class_name);if(constructed_class == NULL){fprintf(stderr,"Class %s not found\n",class_name);exit(EXIT_FAILURE);}method_id = (*env)->GetMethodID(env, constructed_class, "<init>", signature);if(method_id == NULL){fprintf(stderr,"Method <init> not found in class %s\n",class_name);exit(EXIT_FAILURE);}

static inline void _New(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* signature, jvalue* values)
{
    INIT_METHOD_ID_RESOLVER
    generic_t res;
    res.l = (*env)->NewObjectA(env,constructed_class,method_id,values);
    push(stack,index,res);
}
