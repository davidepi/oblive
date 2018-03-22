#define HANDLE_EXCEPTION(STMT,EXCEPTION_NAME) if( STMT )RAISE_EXCEPTION( EXCEPTION_NAME );
#define RAISE_EXCEPTION(NAME) {exception=(*env)->FindClass(env, NAME );(*env)->ThrowNew(env,exception,"");return 0;}
#define CLASS_CAST_EXCEPTION "java/lang/ClassCastException"
#define ARITHMETIC_EXCEPTION "java/lang/ArithmeticException"
