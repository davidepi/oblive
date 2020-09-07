#define FIELD_ID_RESOLVER jfieldID field_id;jclass caller_class = (*env)->FindClass(env, class_name);if(caller_class == NULL){fprintf(stderr,"Class %s not found\n",class_name);exit(EXIT_FAILURE);}field_id = (*env)->GetFieldID(env, caller_class, field_name, field_signature);if(field_id == NULL){fprintf(stderr,"Field %s not found in class %s\n",field_name,class_name);exit(EXIT_FAILURE);}
#define STATIC_FIELD_ID_RESOLVER jfieldID field_id;jclass caller_class = (*env)->FindClass(env, class_name);if(caller_class == NULL){fprintf(stderr,"Class %s not found\n",class_name);exit(EXIT_FAILURE);}field_id = (*env)->GetStaticFieldID(env, caller_class, field_name, field_signature);if(field_id == NULL){fprintf(stderr,"Static field %s not found in class %s\n",field_name,class_name);exit(EXIT_FAILURE);}

static inline char _GetField_jint(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jobject class_instance = pop(socket,stack,index).l;
  if(class_instance == NULL)
    return 1;
  generic_t res;
  res.i = (*env)->GetIntField(env,class_instance,field_id);
  push(socket,stack,index,res);
  return 0;
}

static inline void _GetStatic_jint(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    generic_t res;
  res.i = (*env)->GetStaticIntField(env,caller_class,field_id);
  push(socket,stack,index,res);
}

static inline char _SetField_jint(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jint value = pop(socket,stack,index).i;
  jobject class_instance = pop(socket,stack,index).l;
  if(class_instance == NULL)
    return 1;
  (*env)->SetIntField(env,class_instance,field_id,value);
  return 0;
}

static inline void _SetStatic_jint(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    jint value = pop(socket,stack,index).i;
  (*env)->SetStaticIntField(env,caller_class,field_id,value);
}

static inline char _GetField_jshort(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jobject class_instance = pop(socket,stack,index).l;
  if(class_instance == NULL)
    return 1;
  generic_t res;
  ZERO_OUT_UNION(res);
  res.s = (*env)->GetShortField(env,class_instance,field_id);
  OVERFLOW_CHECK(res,0xFFFF);
  push(socket,stack,index,res);
  return 0;
}

static inline void _GetStatic_jshort(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    generic_t res;
  ZERO_OUT_UNION(res);
  res.s = (*env)->GetStaticShortField(env,caller_class,field_id);
  OVERFLOW_CHECK(res,0xFFFF);
  push(socket,stack,index,res);
}

static inline char _SetField_jshort(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jshort value = pop(socket,stack,index).s;
  jobject class_instance = pop(socket,stack,index).l;
  if(class_instance == NULL)
    return 1;
  (*env)->SetShortField(env,class_instance,field_id,value);
  return 0;
}

static inline void _SetStatic_jshort(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    jshort value = pop(socket,stack,index).s;
  (*env)->SetStaticShortField(env,caller_class,field_id,value);
}

static inline char _GetField_jbyte(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jobject class_instance = pop(socket,stack,index).l;
  if(class_instance == NULL)
    return 1;
  generic_t res;
  res.i = (int)(*env)->GetByteField(env,class_instance,field_id);
  push(socket,stack,index,res);
  return 0;
}

static inline void _GetStatic_jbyte(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    generic_t res;
  res.i = (int)(*env)->GetStaticByteField(env,caller_class,field_id);
  push(socket,stack,index,res);
}

static inline char _SetField_jbyte(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
  jbyte value = pop(socket,stack,index).b;
  jobject class_instance = pop(socket,stack,index).l;
  if(class_instance == NULL)
    return 1;
  (*env)->SetByteField(env,class_instance,field_id,value);
  return 0;
}

static inline void _SetStatic_jbyte(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    jbyte value = pop(socket,stack,index).c;
  (*env)->SetStaticByteField(env,caller_class,field_id,value);
}

static inline char _GetField_jchar(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jobject class_instance = pop(socket,stack,index).l;
  if(class_instance == NULL)
    return 1;
  generic_t res;
  ZERO_OUT_UNION(res);
  res.c = (*env)->GetCharField(env,class_instance,field_id);
  OVERFLOW_CHECK(res,0xFFFF);
  push(socket,stack,index,res);
  return 0;
}

static inline void _GetStatic_jchar(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    generic_t res;
  ZERO_OUT_UNION(res);
  res.c = (*env)->GetStaticCharField(env,caller_class,field_id);
  OVERFLOW_CHECK(res,0xFFFF);
  push(socket,stack,index,res);
}

static inline char _SetField_jchar(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jchar value = pop(socket,stack,index).c;
  jobject class_instance = pop(socket,stack,index).l;
  if(class_instance == NULL)
    return 1;
  (*env)->SetCharField(env,class_instance,field_id,value);
  return 0;
}

static inline void _SetStatic_jchar(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    jchar value = pop(socket,stack,index).c;
  (*env)->SetStaticCharField(env,caller_class,field_id,value);
}

static inline char _GetField_jboolean(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jobject class_instance = pop(socket,stack,index).l;
  if(class_instance == NULL)
    return 1;
  generic_t res;
  ZERO_OUT_UNION(res);
  res.z = (*env)->GetBooleanField(env,class_instance,field_id);
  OVERFLOW_CHECK(res,0xFF);
  push(socket,stack,index,res);
  return 0;
}

static inline void _GetStatic_jboolean(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    generic_t res;
  ZERO_OUT_UNION(res);
  res.z = (*env)->GetStaticBooleanField(env,caller_class,field_id);
  OVERFLOW_CHECK(res,0xFF);
  push(socket,stack,index,res);
}

static inline char _SetField_jboolean(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jboolean value = pop(socket,stack,index).z;
  jobject class_instance = pop(socket,stack,index).l;
  if(class_instance == NULL)
    return 1;
  (*env)->SetBooleanField(env,class_instance,field_id,value);
  return 0;
}

static inline void _SetStatic_jboolean(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    jboolean value = pop(socket,stack,index).z;
  (*env)->SetStaticBooleanField(env,caller_class,field_id,value);
}

static inline char _GetField_jfloat(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jobject class_instance = pop(socket,stack,index).l;
  if(class_instance == NULL)
    return 1;
  generic_t res;
  res.f = (*env)->GetFloatField(env,class_instance,field_id);
  push(socket,stack,index,res);
  return 0;
}

static inline void _GetStatic_jfloat(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    generic_t res;
  res.f = (*env)->GetStaticFloatField(env,caller_class,field_id);
  push(socket,stack,index,res);
}

static inline char _SetField_jfloat(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jfloat value = pop(socket,stack,index).f;
  jobject class_instance = pop(socket,stack,index).l;
  if(class_instance == NULL)
    return 1;
  (*env)->SetFloatField(env,class_instance,field_id,value);
  return 0;
}

static inline void _SetStatic_jfloat(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    jfloat value = pop(socket,stack,index).f;
  (*env)->SetStaticFloatField(env,caller_class,field_id,value);
}

static inline char _GetField_jdouble(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jobject class_instance = pop(socket,stack,index).l;
  if(class_instance == NULL)
    return 1;
  generic_t res;
  res.d = (*env)->GetDoubleField(env,class_instance,field_id);
  push2(socket,stack,index,res);
  return 0;
}

static inline void _GetStatic_jdouble(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    generic_t res;
  res.d = (*env)->GetStaticDoubleField(env,caller_class,field_id);
  push2(socket,stack,index,res);
}

static inline char _SetField_jdouble(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jdouble value = pop2(socket,stack,index).d;
  jobject class_instance = pop(socket,stack,index).l;
  if(class_instance == NULL)
    return 1;
  (*env)->SetDoubleField(env,class_instance,field_id,value);
  return 0;
}

static inline void _SetStatic_jdouble(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    jdouble value = pop2(socket,stack,index).d;
  (*env)->SetStaticDoubleField(env,caller_class,field_id,value);
}

static inline char _GetField_jlong(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jobject class_instance = pop(socket,stack,index).l;
  if(class_instance == NULL)
    return 1;
  generic_t res;
  res.j = (*env)->GetLongField(env,class_instance,field_id);
  push2(socket,stack,index,res);
  return 0;
}

static inline void _GetStatic_jlong(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    generic_t res;
  res.j = (*env)->GetStaticLongField(env,caller_class,field_id);
  push2(socket,stack,index,res);
}

static inline char _SetField_jlong(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jlong value = pop2(socket,stack,index).j;
  jobject class_instance = pop(socket,stack,index).l;
  if(class_instance == NULL)
    return 1;
  (*env)->SetLongField(env,class_instance,field_id,value);
  return 0;
}

static inline void _SetStatic_jlong(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    jlong value = pop2(socket,stack,index).j;
  (*env)->SetStaticLongField(env,caller_class,field_id,value);
}

static inline char _GetField_jobject(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jobject class_instance = pop(socket,stack,index).l;
  if(class_instance == NULL)
    return 1;
  generic_t res;
  res.l = (*env)->GetObjectField(env,class_instance,field_id);
  push(socket,stack,index,res);
  return 0;
}

static inline void _GetStatic_jobject(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    generic_t res;
  res.l = (*env)->GetStaticObjectField(env,caller_class,field_id);
  push(socket,stack,index,res);
}

static inline char _SetField_jobject(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  FIELD_ID_RESOLVER
    jobject value = pop(socket,stack,index).l;
  jobject class_instance = pop(socket,stack,index).l;
  if(class_instance == NULL)
    return 1;
  (*env)->SetObjectField(env,class_instance,field_id,value);
  return 0;
}

static inline void _SetStatic_jobject(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
  STATIC_FIELD_ID_RESOLVER
    jobject value = pop(socket,stack,index).l;
  (*env)->SetStaticObjectField(env,caller_class,field_id,value);
}
