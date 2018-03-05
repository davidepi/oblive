#define FIELD_ID_RESOLVER jfieldID field_id;jclass caller_class = (*env)->FindClass(env, class_name);if(caller_class == NULL){fprintf(stderr,"Class %s not found\n",class_name);exit(EXIT_FAILURE);}field_id = (*env)->GetFieldID(env, caller_class, field_name, field_signature);if(field_id == NULL){fprintf(stderr,"Field %s not found in class %s\n",field_name,class_name);exit(EXIT_FAILURE);}
#define STATIC_FIELD_ID_RESOLVER jfieldID field_id;jclass caller_class = (*env)->FindClass(env, class_name);if(caller_class == NULL){fprintf(stderr,"Class %s not found\n",class_name);exit(EXIT_FAILURE);}field_id = (*env)->GetStaticFieldID(env, caller_class, field_name, field_signature);if(field_id == NULL){fprintf(stderr,"Static field %s not found in class %s\n",field_name,class_name);exit(EXIT_FAILURE);}

static inline void _GetField_jint(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
    FIELD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
    generic_t res;
    res.i = (*env)->GetIntField(env,class_instance,field_id);
    push(stack,index,res);
}

static inline void _GetStatic_jint(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
    STATIC_FIELD_ID_RESOLVER
    generic_t res;
    res.i = (*env)->GetStaticIntField(env,caller_class,field_id);
    push(stack,index,res);
}

static inline void _SetField_jint(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
    FIELD_ID_RESOLVER
    jint value = pop(stack,index).i;
    jobject class_instance = pop(stack,index).l;
    (*env)->SetIntField(env,class_instance,field_id,value);
}

static inline void _SetStatic_jint(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
    STATIC_FIELD_ID_RESOLVER
    jint value = pop(stack,index).i;
    (*env)->SetStaticIntField(env,caller_class,field_id,value);
}

static inline void _GetField_jshort(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
    FIELD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
    generic_t res;
    res.s = (*env)->GetShortField(env,class_instance,field_id);
    push(stack,index,res);
}

static inline void _GetStatic_jshort(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
    STATIC_FIELD_ID_RESOLVER
    generic_t res;
    res.s = (*env)->GetStaticIntField(env,caller_class,field_id);
    push(stack,index,res);
}

static inline void _SetField_jshort(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
    FIELD_ID_RESOLVER
    jshort value = pop(stack,index).s;
    jobject class_instance = pop(stack,index).l;
    (*env)->SetIntField(env,class_instance,field_id,value);
}

static inline void _SetStatic_jshort(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
    STATIC_FIELD_ID_RESOLVER
    jshort value = pop(stack,index).s;
    (*env)->SetStaticIntField(env,caller_class,field_id,value);
}

static inline void _GetField_jbyte(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
    FIELD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
    generic_t res;
    res.b = (*env)->GetShortField(env,class_instance,field_id);
    push(stack,index,res);
}

static inline void _GetStatic_jbyte(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
    STATIC_FIELD_ID_RESOLVER
    generic_t res;
    res.b = (*env)->GetStaticIntField(env,caller_class,field_id);
    push(stack,index,res);
}

static inline void _SetField_jbyte(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
    FIELD_ID_RESOLVER
    jshort value = pop(stack,index).b;
    jobject class_instance = pop(stack,index).l;
    (*env)->SetIntField(env,class_instance,field_id,value);
}

static inline void _SetStatic_jbyte(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
    STATIC_FIELD_ID_RESOLVER
    jshort value = pop(stack,index).b;
    (*env)->SetStaticIntField(env,caller_class,field_id,value);
}
