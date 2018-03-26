#define HANDLE_EXCEPTION(STMT,EXCEPTION_NAME) if( STMT )RAISE_EXCEPTION( EXCEPTION_NAME );
//RETURN_EXCEPTION is built at static time after knowing if the function should return something or not. It is expanded into either `return;` or `return 0;`
#define RAISE_EXCEPTION(NAME) {exception=(*env)->FindClass(env, NAME );(*env)->ThrowNew(env,exception,"");RETURN_EXCEPTION;}
#define CLASS_CAST_EXCEPTION "java/lang/ClassCastException"
#define ARITHMETIC_EXCEPTION "java/lang/ArithmeticException"
#define ARRAY_STORE_EXCEPTION "java/lang/ArrayStoreException"
#define INDEX_OUT_OF_BOUNDS_EXCEPTION "java/lang/IndexOutOfBoundsException"
