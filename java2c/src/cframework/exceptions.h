#define CLASS_CAST_EXCEPTION "java/lang/ClassCastException"
#define RAISE_EXCEPTION(NAME) {exception=(*env)->FindClass(env, NAME );(*env)->ThrowNew(env,exception,"");return 0;}
