#define VIRTUAL_METHOD_ID_RESOLVER   jmethodID method_id;jclass caller_class = (*env)->FindClass(env, owner);if(caller_class == NULL){fprintf(stderr,"Class %s not found\n",owner);exit(EXIT_FAILURE);}method_id = (*env)->GetMethodID(env, caller_class, name, signature);if(method_id == NULL){fprintf(stderr,"Method %s not found\n",owner);exit(EXIT_FAILURE);}
#define STATIC_METHOD_ID_RESOLVER   jmethodID method_id;jclass caller_class = (*env)->FindClass(env, owner);if(caller_class == NULL){fprintf(stderr,"Class %s not found\n",owner);exit(EXIT_FAILURE);}method_id = (*env)->GetStaticMethodID(env, caller_class, name, signature);if(method_id == NULL){fprintf(stderr,"Method %s not found\n",owner);exit(EXIT_FAILURE);}

static inline void _InvokeVirtual_jint(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    VIRTUAL_METHOD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
    generic_t res;
    res.i = (*env)->CallIntMethodA(env,class_instance,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeStatic_jint(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    STATIC_METHOD_ID_RESOLVER
    generic_t res;
    res.i = (*env)->CallStaticIntMethodA(env,caller_class,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeVirtual_jboolean(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    VIRTUAL_METHOD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
    generic_t res;
    res.z = (*env)->CallBooleanMethodA(env,class_instance,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeVirtual_jbyte(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    VIRTUAL_METHOD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
    generic_t res;
    res.b = (*env)->CallByteMethodA(env,class_instance,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeVirtual_jchar(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    VIRTUAL_METHOD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
    generic_t res;
    res.c = (*env)->CallCharMethodA(env,class_instance,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeVirtual_jshort(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    VIRTUAL_METHOD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
    generic_t res;
    res.s = (*env)->CallShortMethodA(env,class_instance,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeVirtual_jlong(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    VIRTUAL_METHOD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
    generic_t res;
    res.j = (*env)->CallLongMethodA(env,class_instance,method_id,values);
    push2(stack,index,res);
}

static inline void _InvokeVirtual_jfloat(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    VIRTUAL_METHOD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
    generic_t res;
    res.f = (*env)->CallFloatMethodA(env,class_instance,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeVirtual_jdouble(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    VIRTUAL_METHOD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
    generic_t res;
    res.d = (*env)->CallDoubleMethodA(env,class_instance,method_id,values);
    push2(stack,index,res);
}

static inline void _InvokeVirtual_jobject(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    VIRTUAL_METHOD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
    generic_t res;
    res.l = (*env)->CallObjectMethodA(env,class_instance,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeVirtual_void(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    VIRTUAL_METHOD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
    (*env)->CallVoidMethodA(env,class_instance,method_id,values);
}

