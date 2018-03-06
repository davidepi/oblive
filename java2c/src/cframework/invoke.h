#define VIRTUAL_METHOD_ID_RESOLVER   jmethodID method_id;jclass caller_class = (*env)->FindClass(env, owner);if(caller_class == NULL){fprintf(stderr,"Class %s not found\n",owner);exit(EXIT_FAILURE);}method_id = (*env)->GetMethodID(env, caller_class, name, signature);if(method_id == NULL){fprintf(stderr,"Method %s not found in class %s\n",name,owner);exit(EXIT_FAILURE);}
#define STATIC_METHOD_ID_RESOLVER   jmethodID method_id;jclass caller_class = (*env)->FindClass(env, owner);if(caller_class == NULL){fprintf(stderr,"Class %s not found\n",owner);exit(EXIT_FAILURE);}method_id = (*env)->GetStaticMethodID(env, caller_class, name, signature);if(method_id == NULL){fprintf(stderr,"Method %s not found in class %s\n",name,owner);exit(EXIT_FAILURE);}

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

static inline void _InvokeSpecial_jint(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    VIRTUAL_METHOD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
    generic_t res;
    //Nonvirtual because invokespecial is used to call super.method(). 
    //If CallIntMethodA is used, if there is an ovveride of the method in a subclass that will be called instead, and it is wrong
    res.i = (*env)->CallNonvirtualIntMethodA(env,class_instance,caller_class,method_id,values);
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

static inline void _InvokeStatic_jboolean(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    STATIC_METHOD_ID_RESOLVER
    generic_t res;
    res.z = (*env)->CallStaticBooleanMethodA(env,caller_class,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeSpecial_jboolean(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    VIRTUAL_METHOD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
    generic_t res;
    //Nonvirtual because invokespecial is used to call super.method(). 
    //If CallIntMethodA is used, if there is an ovveride of the method in a subclass that will be called instead, and it is wrong
    res.z = (*env)->CallNonvirtualBooleanMethodA(env,class_instance,caller_class,method_id,values);
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

static inline void _InvokeStatic_jbyte(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    STATIC_METHOD_ID_RESOLVER
    generic_t res;
    res.b = (*env)->CallStaticByteMethodA(env,caller_class,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeSpecial_jbyte(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    VIRTUAL_METHOD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
    generic_t res;
    //Nonvirtual because invokespecial is used to call super.method(). 
    //If CallIntMethodA is used, if there is an ovveride of the method in a subclass that will be called instead, and it is wrong
    res.b = (*env)->CallNonvirtualByteMethodA(env,class_instance,caller_class,method_id,values);
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

static inline void _InvokeStatic_jchar(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    STATIC_METHOD_ID_RESOLVER
    generic_t res;
    res.c = (*env)->CallStaticCharMethodA(env,caller_class,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeSpecial_jchar(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    VIRTUAL_METHOD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
    generic_t res;
    //Nonvirtual because invokespecial is used to call super.method(). 
    //If CallIntMethodA is used, if there is an ovveride of the method in a subclass that will be called instead, and it is wrong
    res.c = (*env)->CallNonvirtualCharMethodA(env,class_instance,caller_class,method_id,values);
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

static inline void _InvokeStatic_jshort(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    STATIC_METHOD_ID_RESOLVER
    generic_t res;
    res.s = (*env)->CallStaticShortMethodA(env,caller_class,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeSpecial_jshort(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    VIRTUAL_METHOD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
    generic_t res;
    //Nonvirtual because invokespecial is used to call super.method(). 
    //If CallIntMethodA is used, if there is an ovveride of the method in a subclass that will be called instead, and it is wrong
    res.s = (*env)->CallNonvirtualShortMethodA(env,class_instance,caller_class,method_id,values);
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

static inline void _InvokeStatic_jlong(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    STATIC_METHOD_ID_RESOLVER
    generic_t res;
    res.j = (*env)->CallStaticLongMethodA(env,caller_class,method_id,values);
    push2(stack,index,res);
}

static inline void _InvokeSpecial_jlong(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    VIRTUAL_METHOD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
    generic_t res;
    //Nonvirtual because invokespecial is used to call super.method(). 
    //If CallIntMethodA is used, if there is an ovveride of the method in a subclass that will be called instead, and it is wrong
    res.j = (*env)->CallNonvirtualLongMethodA(env,class_instance,caller_class,method_id,values);
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

static inline void _InvokeStatic_jfloat(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    STATIC_METHOD_ID_RESOLVER
    generic_t res;
    res.f = (*env)->CallStaticFloatMethodA(env,caller_class,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeSpecial_jfloat(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    VIRTUAL_METHOD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
    generic_t res;
    //Nonvirtual because invokespecial is used to call super.method(). 
    //If CallIntMethodA is used, if there is an ovveride of the method in a subclass that will be called instead, and it is wrong
    res.f = (*env)->CallNonvirtualFloatMethodA(env,class_instance,caller_class,method_id,values);
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

static inline void _InvokeStatic_jdouble(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    STATIC_METHOD_ID_RESOLVER
    generic_t res;
    res.d = (*env)->CallStaticDoubleMethodA(env,caller_class,method_id,values);
    push2(stack,index,res);
}

static inline void _InvokeSpecial_jdouble(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    VIRTUAL_METHOD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
    generic_t res;
    //Nonvirtual because invokespecial is used to call super.method(). 
    //If CallIntMethodA is used, if there is an ovveride of the method in a subclass that will be called instead, and it is wrong
    res.d = (*env)->CallNonvirtualDoubleMethodA(env,class_instance,caller_class,method_id,values);
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

static inline void _InvokeStatic_jobject(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    STATIC_METHOD_ID_RESOLVER
    generic_t res;
    res.l = (*env)->CallStaticObjectMethodA(env,caller_class,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeSpecial_jobject(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    VIRTUAL_METHOD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
    generic_t res;
    //Nonvirtual because invokespecial is used to call super.method(). 
    //If CallIntMethodA is used, if there is an ovveride of the method in a subclass that will be called instead, and it is wrong
    res.l = (*env)->CallNonvirtualObjectMethodA(env,class_instance,caller_class,method_id,values);
    push(stack,index,res);
}

static inline void _InvokeVirtual_void(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    VIRTUAL_METHOD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
    (*env)->CallVoidMethodA(env,class_instance,method_id,values);
}

static inline void _InvokeStatic_void(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    STATIC_METHOD_ID_RESOLVER
    (*env)->CallStaticVoidMethodA(env,caller_class,method_id,values);
}

static inline void _InvokeSpecial_void(JNIEnv* env, generic_t* stack, uint32_t* index, const char* owner, const char* name, const char* signature, jvalue* values)
{
    VIRTUAL_METHOD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
    //Nonvirtual because invokespecial is used to call super.method(). 
    //If CallIntMethodA is used, if there is an ovveride of the method in a subclass that will be called instead, and it is wrong
    (*env)->CallNonvirtualVoidMethodA(env,class_instance,caller_class,method_id,values);
}
