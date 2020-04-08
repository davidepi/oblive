#define FIELD_ID_RESOLVER jfieldID field_id;jclass caller_class = (*env)->FindClass(env, class_name);if(caller_class == NULL){fprintf(stderr,"Class %s not found\n",class_name);exit(EXIT_FAILURE);}field_id = (*env)->GetFieldID(env, caller_class, field_name, field_signature);if(field_id == NULL){fprintf(stderr,"Field %s not found in class %s\n",field_name,class_name);exit(EXIT_FAILURE);}
#define STATIC_FIELD_ID_RESOLVER jfieldID field_id;jclass caller_class = (*env)->FindClass(env, class_name);if(caller_class == NULL){fprintf(stderr,"Class %s not found\n",class_name);exit(EXIT_FAILURE);}field_id = (*env)->GetStaticFieldID(env, caller_class, field_name, field_signature);if(field_id == NULL){fprintf(stderr,"Static field %s not found in class %s\n",field_name,class_name);exit(EXIT_FAILURE);}

static inline char _GetField_jint(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
  if(class_instance == NULL)
    return 1;
  generic_t res;
  res.i = (*env)->GetIntField(env,class_instance,field_id);
  push(stack,index,res);
  return 0;
}

static inline void _GetStatic_jint(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    generic_t res;
  res.i = (*env)->GetStaticIntField(env,caller_class,field_id);
  push(stack,index,res);
}

static inline char _SetField_jint(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jint value = pop(stack,index).i;
  jobject class_instance = pop(stack,index).l;
  if(class_instance == NULL)
    return 1;
  (*env)->SetIntField(env,class_instance,field_id,value);
  return 0;
}

static inline void _SetStatic_jint(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    jint value = pop(stack,index).i;
  (*env)->SetStaticIntField(env,caller_class,field_id,value);
}

static inline char _GetField_jshort(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
  if(class_instance == NULL)
    return 1;
  generic_t res;
  ZERO_OUT_UNION(res);
  res.s = (*env)->GetShortField(env,class_instance,field_id);
  OVERFLOW_CHECK(res,0xFFFF);
  push(stack,index,res);
  return 0;
}

static inline void _GetStatic_jshort(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    generic_t res;
  ZERO_OUT_UNION(res);
  res.s = (*env)->GetStaticShortField(env,caller_class,field_id);
  OVERFLOW_CHECK(res,0xFFFF);
  push(stack,index,res);
}

static inline char _SetField_jshort(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jshort value = pop(stack,index).s;
  jobject class_instance = pop(stack,index).l;
  if(class_instance == NULL)
    return 1;
  (*env)->SetShortField(env,class_instance,field_id,value);
  return 0;
}

static inline void _SetStatic_jshort(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    jshort value = pop(stack,index).s;
  (*env)->SetStaticShortField(env,caller_class,field_id,value);
}

static inline char _GetField_jbyte(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
  if(class_instance == NULL)
    return 1;
  generic_t res;
  res.i = (int)(*env)->GetByteField(env,class_instance,field_id);
  push(stack,index,res);
  return 0;
}

static inline void _GetStatic_jbyte(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    generic_t res;
  res.i = (int)(*env)->GetStaticByteField(env,caller_class,field_id);
  push(stack,index,res);
}

static inline char _SetField_jbyte(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
  jbyte value = pop(stack,index).b;
  jobject class_instance = pop(stack,index).l;
  if(class_instance == NULL)
    return 1;
  (*env)->SetByteField(env,class_instance,field_id,value);
  return 0;
}

static inline void _SetStatic_jbyte(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    jbyte value = pop(stack,index).c;
  (*env)->SetStaticByteField(env,caller_class,field_id,value);
}

static inline char _GetField_jchar(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
  if(class_instance == NULL)
    return 1;
  generic_t res;
  ZERO_OUT_UNION(res);
  res.c = (*env)->GetCharField(env,class_instance,field_id);
  OVERFLOW_CHECK(res,0xFFFF);
  push(stack,index,res);
  return 0;
}

static inline void _GetStatic_jchar(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    generic_t res;
  ZERO_OUT_UNION(res);
  res.c = (*env)->GetStaticCharField(env,caller_class,field_id);
  OVERFLOW_CHECK(res,0xFFFF);
  push(stack,index,res);
}

static inline char _SetField_jchar(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jchar value = pop(stack,index).c;
  jobject class_instance = pop(stack,index).l;
  if(class_instance == NULL)
    return 1;
  (*env)->SetCharField(env,class_instance,field_id,value);
  return 0;
}

static inline void _SetStatic_jchar(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    jchar value = pop(stack,index).c;
  (*env)->SetStaticCharField(env,caller_class,field_id,value);
}

static inline char _GetField_jboolean(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
  if(class_instance == NULL)
    return 1;
  generic_t res;
  ZERO_OUT_UNION(res);
  res.z = (*env)->GetBooleanField(env,class_instance,field_id);
  OVERFLOW_CHECK(res,0xFF);
  push(stack,index,res);
  return 0;
}

static inline void _GetStatic_jboolean(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    generic_t res;
  ZERO_OUT_UNION(res);
  res.z = (*env)->GetStaticBooleanField(env,caller_class,field_id);
  OVERFLOW_CHECK(res,0xFF);
  push(stack,index,res);
}

static inline char _SetField_jboolean(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jboolean value = pop(stack,index).z;
  jobject class_instance = pop(stack,index).l;
  if(class_instance == NULL)
    return 1;
  (*env)->SetBooleanField(env,class_instance,field_id,value);
  return 0;
}

static inline void _SetStatic_jboolean(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    jboolean value = pop(stack,index).z;
  (*env)->SetStaticBooleanField(env,caller_class,field_id,value);
}

static inline char _GetField_jfloat(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
  if(class_instance == NULL)
    return 1;
  generic_t res;
  res.f = (*env)->GetFloatField(env,class_instance,field_id);
  push(stack,index,res);
  return 0;
}

static inline void _GetStatic_jfloat(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    generic_t res;
  res.f = (*env)->GetStaticFloatField(env,caller_class,field_id);
  push(stack,index,res);
}

static inline char _SetField_jfloat(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jfloat value = pop(stack,index).f;
  jobject class_instance = pop(stack,index).l;
  if(class_instance == NULL)
    return 1;
  (*env)->SetFloatField(env,class_instance,field_id,value);
  return 0;
}

static inline void _SetStatic_jfloat(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    jfloat value = pop(stack,index).f;
  (*env)->SetStaticFloatField(env,caller_class,field_id,value);
}

static inline char _GetField_jdouble(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
  if(class_instance == NULL)
    return 1;
  generic_t res;
  res.d = (*env)->GetDoubleField(env,class_instance,field_id);
  push2(stack,index,res);
  return 0;
}

static inline void _GetStatic_jdouble(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    generic_t res;
  res.d = (*env)->GetStaticDoubleField(env,caller_class,field_id);
  push2(stack,index,res);
}

static inline char _SetField_jdouble(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jdouble value = pop2(stack,index).d;
  jobject class_instance = pop(stack,index).l;
  if(class_instance == NULL)
    return 1;
  (*env)->SetDoubleField(env,class_instance,field_id,value);
  return 0;
}

static inline void _SetStatic_jdouble(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    jdouble value = pop2(stack,index).d;
  (*env)->SetStaticDoubleField(env,caller_class,field_id,value);
}

static inline char _GetField_jlong(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
  if(class_instance == NULL)
    return 1;
  generic_t res;
  res.j = (*env)->GetLongField(env,class_instance,field_id);
  push2(stack,index,res);
  return 0;
}

static inline void _GetStatic_jlong(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    generic_t res;
  res.j = (*env)->GetStaticLongField(env,caller_class,field_id);
  push2(stack,index,res);
}

static inline char _SetField_jlong(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jlong value = pop2(stack,index).j;
  jobject class_instance = pop(stack,index).l;
  if(class_instance == NULL)
    return 1;
  (*env)->SetLongField(env,class_instance,field_id,value);
  return 0;
}

static inline void _SetStatic_jlong(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    jlong value = pop2(stack,index).j;
  (*env)->SetStaticLongField(env,caller_class,field_id,value);
}

static inline char _GetField_jobject(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
  if(class_instance == NULL)
    return 1;
  generic_t res;
  res.l = (*env)->GetObjectField(env,class_instance,field_id);
  push(stack,index,res);
  return 0;
}

static inline void _GetStatic_jobject(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    generic_t res;
  res.l = (*env)->GetStaticObjectField(env,caller_class,field_id);
  push(stack,index,res);
}

static inline char _SetField_jobject(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jobject value = pop(stack,index).l;
  jobject class_instance = pop(stack,index).l;
  if(class_instance == NULL)
    return 1;
  (*env)->SetObjectField(env,class_instance,field_id,value);
  return 0;
}

static inline void _SetStatic_jobject(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    jobject value = pop(stack,index).l;
  (*env)->SetStaticObjectField(env,caller_class,field_id,value);
}
