static inline void push(int socket, generic_t* stack, uint32_t* index, generic_t val)
{
#ifdef SELF_DEBUG
    run_command_params(socket, PUSH, val);
#else
    stack[(*index)++] = val;
#endif
}

static inline void push2(int socket, generic_t* stack, uint32_t* index, generic_t val)
{
#ifdef SELF_DEBUG
    run_command_params(socket, PUSH2, val);
#else
  stack[(*index)++] = val;
  (*index)++;
#endif
}

static inline generic_t pop(int socket, generic_t* stack, uint32_t* index)
{
#ifdef SELF_DEBUG
    return run_command(socket, POP);
#else
    return stack[--(*index)];
#endif
}

static inline generic_t pop2(int socket, generic_t* stack, uint32_t* index)
{
#ifdef SELF_DEBUG
    return run_command(socket, POP2);
#else
  --(*index);
  return stack[--(*index)];
#endif
}

// the java in the name is to avoid clash with the POSIX dup
static inline void dupjava(int socket, generic_t* stack, uint32_t* index)
{
#ifdef SELF_DEBUG
    run_command(socket, DUP);
#else
  generic_t val = stack[(*index)-1];
  push(socket, stack,index,val);
#endif
}

// the java in the name is to avoid clash with the POSIX dup2
static inline void dup2java(int socket, generic_t* stack, uint32_t* index)
{
#ifdef SELF_DEBUG
    run_command(socket, DUP2);
#else
  generic_t val0 = stack[(*index)-2];
  generic_t val1 = stack[(*index)-1];
  push(socket,stack,index,val0);
  push(socket,stack,index,val1);
#endif
}

static inline void dupx1(int socket, generic_t* stack, uint32_t* index)
{
#ifdef SELF_DEBUG
    run_command(socket, DUPX1);
#else
  generic_t duplicateme = pop(socket,stack,index);
  generic_t middleval = pop(socket,stack,index);
  push(socket,stack,index,duplicateme);
  push(socket,stack,index,middleval);
  push(socket,stack,index,duplicateme);
#endif
}

static inline void dupx2(int socket, generic_t* stack, uint32_t* index)
{
#ifdef SELF_DEBUG
    run_command(socket, DUPX2);
#else
  generic_t duplicateme = pop(socket,stack,index);
  generic_t middleval1 = pop(socket,stack,index);
  generic_t middleval0 = pop(socket,stack,index);
  push(socket,stack,index,duplicateme);
  push(socket,stack,index,middleval0);
  push(socket,stack,index,middleval1);
  push(socket,stack,index,duplicateme);
#endif
}

static inline void dup2x1(int socket, generic_t* stack, uint32_t* index)
{
#ifdef SELF_DEBUG
    run_command(socket, DUP2X1);
#else
  generic_t duplicateme1 = pop(socket,stack,index);
  generic_t duplicateme0 = pop(socket,stack,index);
  generic_t middleval = pop(socket,stack,index);
  push(socket,stack,index,duplicateme0);
  push(socket,stack,index,duplicateme1);
  push(socket,stack,index,middleval);
  push(socket,stack,index,duplicateme0);
  push(socket,stack,index,duplicateme1);
#endif
}

static inline void dup2x2(int socket, generic_t* stack, uint32_t* index)
{
#ifdef SELF_DEBUG
    run_command(socket, DUP2X2);
#else
  generic_t duplicateme1 = pop(socket,stack,index);
  generic_t duplicateme0 = pop(socket,stack,index);
  generic_t middleval1 = pop(socket,stack,index);
  generic_t middleval0 = pop(socket,stack,index);
  push(socket,stack,index,duplicateme0);
  push(socket,stack,index,duplicateme1);
  push(socket,stack,index,middleval0);
  push(socket,stack,index,middleval1);
  push(socket,stack,index,duplicateme0);
  push(socket,stack,index,duplicateme1);
#endif
}

static inline void swap(int socket, generic_t* stack, uint32_t* index)
{
#ifdef SELF_DEBUG
    run_command(socket, SWAP);
#else
  generic_t tmp = stack[(*index)-2];
  stack[(*index)-2] = stack[(*index)-1];
  stack[(*index)-1] = tmp;
#endif
}

static inline void push0(int socket, generic_t* stack, uint32_t* index)
{
  generic_t pushme;
  pushme.l = NULL;
  push(socket,stack,index,pushme);
}

static inline void pushi(int socket, generic_t* stack, uint32_t* index, jint val)
{
  generic_t pushme;
  pushme.i = val;
  push(socket,stack,index,pushme);
}

static inline void pushl(int socket, generic_t* stack, uint32_t* index, jlong val)
{
  generic_t pushme;
  pushme.j = val;
  push2(socket,stack,index,pushme);
}

static inline void pushf(int socket, generic_t* stack, uint32_t* index, jfloat val)
{
  generic_t pushme;
  pushme.f = val;
  push(socket,stack,index,pushme);
}

static inline void pushd(int socket, generic_t* stack, uint32_t* index, jdouble val)
{
  generic_t pushme;
  pushme.d = val;
  push2(socket,stack,index,pushme);
}

static inline void _LdcString(int socket, JNIEnv* env, generic_t* stack, uint32_t* index,
                        const jchar* str, int len)
{
  jstring string = (*env)->NewString(env,str,len);
  generic_t pushme;
  pushme.l = string;
  push(socket,stack,index,pushme);
}

static inline void _LdcClassRef(int socket, JNIEnv* env, generic_t* stack, uint32_t* index, const char* name)
{
    jclass requested_class = (*env)->FindClass(env, name);
    generic_t pushme;
    pushme.l = requested_class;
    push(socket,stack, index, pushme);
}

static inline void _Load(int socket, generic_t* stack, generic_t* arg, uint32_t* index, int valueIndex)
{
    push(socket,stack,index,arg[valueIndex]);
}

static inline void _Load2(int socket, generic_t* stack, generic_t* arg, uint32_t* index, int valueIndex)
{
    push2(socket,stack,index,arg[valueIndex]);
}

static inline void _Store(int socket, generic_t* stack, generic_t* arg, uint32_t* index, int valueIndex)
{
  arg[valueIndex] = pop(socket,stack,index);
}

static inline void _Store2(int socket, generic_t* stack, generic_t* arg, uint32_t* index, int valueIndex)
{
  arg[valueIndex] = pop2(socket,stack,index);
}

static inline void _MonitorEnter(int socket, JNIEnv* env, generic_t* stack, uint32_t* index)
{
  generic_t lock = pop(socket,stack,index);
  (*env)->MonitorEnter(env, lock.l);
}

static inline void _MonitorExit(int socket, JNIEnv* env, generic_t* stack, uint32_t* index)
{
  generic_t lock = pop(socket,stack,index);
  (*env)->MonitorExit(env,lock.l);
}

