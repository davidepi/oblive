#define FIELD_ID_RESOLVER   jfieldID field_id;jclass caller_class = (*env)->FindClass(env, class_name);if(caller_class == NULL){fprintf(stderr,"Class %s not found\n",class_name);exit(EXIT_FAILURE);}field_id = (*env)->GetFieldID(env, caller_class, field_name, field_signature);if(field_id == NULL){fprintf(stderr,"Method %s not found\n",class_name);exit(EXIT_FAILURE);}
static inline void _GetField_jint(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
    FIELD_ID_RESOLVER
    jobject class_instance = pop(stack,index).l;
    generic_t res;
    res.i = (*env)->GetIntField(env,class_instance,field_id);
    push(stack,index,res);
}


static inline void _SetField_jint(JNIEnv* env, generic_t* stack, uint32_t* index, const char* class_name, const char* field_name, const char* field_signature)
{
    FIELD_ID_RESOLVER
    jint value = pop(stack,index).i;
    jobject class_instance = pop(stack,index).l;
    (*env)->SetIntField(env,class_instance,field_id,value);
}
