static inline void time_start(time_t* start)
{
    time(start);
}

static inline void time_check(time_t* start)
{
    if(difftime(time(NULL), *start) > 0)
    {
        exit(EXIT_SUCCESS);
    }
}

static inline void self_debug(JNIEnv *env)
{
    const char child_process[] = "/tmp/attach.o";
    // create the Process
    jstring child_java_string = (*env)->NewStringUTF(env, child_process);
    jclass string_class = (*env)->FindClass(env, "java/lang/String");
    jobjectArray func_param = (*env)->NewObjectArray(env, 1,string_class, child_java_string);
    jclass pb_class = (*env)->FindClass(env, "java/lang/ProcessBuilder");
    jmethodID method_id = (*env)->GetMethodID(env, pb_class, "<init>", "([Ljava/lang/String;)V");
    jobject pb = (*env)->NewObject(env, pb_class, method_id, func_param);
    //invoke the process
    method_id = (*env)->GetMethodID(env, pb_class, "start", "()Ljava/lang/Process;");
    jobject process = (*env)->CallObjectMethod(env, pb, method_id);
    //capture stdout (part of Read-the-PID)
    jclass process_class = (*env)->FindClass(env, "java/lang/Process");
    method_id = (*env)->GetMethodID(env, process_class, "getInputStream", "()Ljava/io/InputStream;");
    jobject inputstream = (*env)->CallObjectMethod(env, process, method_id);
    //read stdout (part of Read-the-PID)
    jbyteArray arrayJava = (*env)->NewByteArray(env, 16);
    jclass input_class = (*env)->FindClass(env, "java/io/InputStream");
    method_id = (*env)->GetMethodID(env, input_class, "read", "([BII)I");
    jint ret = (*env)->CallIntMethod(env, inputstream, method_id, arrayJava, 0, 16);
    jbyte* data = (*env)->GetByteArrayElements(env, arrayJava, NULL);
    pid_t child = atoi((char*)data);
    (*env)->ReleaseByteArrayElements(env, arrayJava, data, JNI_ABORT);
    printf("%d\n", child);
    if(ptrace(PTRACE_SEIZE, child, NULL, NULL) != -1)
    {

    }
    else
    {
        perror("Error");
        exit(EXIT_SUCCESS);
    }
}

//static inline void self_debug()
//{
//    pid_t parent_pid = getpid();
//    pid_t child_pid = fork();
//    if (child_pid == 0)
//    {
//        int true_child_pid = getpid();
//        if(ptrace(PTRACE_SEIZE, parent_pid, NULL, NULL) != -1)
//        {
//        }
//        else
//        {
//            exit(EXIT_SUCCESS);
//        }
//    }
//    else {
//        if(prctl(PR_SET_PTRACER, child_pid) != -1)
//        {
//        }
//        else
//        {
//            exit(EXIT_SUCCESS);
//        }
//        int status;
//        waitpid(child_pid, &status, 0);
//        exit(EXIT_SUCCESS);
//    }
//}

/*----------------- Originally written by S.Berlato <sberlato@fbk.eu> -----------------*\
|                 ANTI-DEBUGGING PROTECTION AGAINST JAVA-LEVEL DEBUGGER                 |
| This method checks whether the "jdwp.so" library, needed for java debugging, has been |
| loaded. If so, this method overwrites some of the library code segments with the 0xC3 |
| opcode, that corresponds to "return" in x86 ISA. In particular, this method sets 0XC3 |
| at the beginning of each function in the "jdwp.so" library. In this way, the debugger |
| returns without executing the function (e.g., set breakpoint) and without breaking it |
| Indeed we want our Java Anti-Debuggging protection to operate as stealthy as possible |
| Note: how to know when a function begins in the code segment of the "jdwp.so" library |
| without having all the addresses? Well, usually each function starts with "push rbp". |
\*-------------------------------------------------------------------------------------*/
static inline void break_java_debugger()
{
    // Flag to understand whether we
    // applied the protection or not
    int protection_applied = 0;

    // Get the pid of the process to get
    // the related /proc/<pid>/maps file
    int pid_integer = getpid();

    // Convert the pid from integer to string
    int pid_length = (int)((ceil(log10(pid_integer)) + 1) * sizeof(char));
    char pid_string[pid_length];
    sprintf(pid_string, "%i", pid_integer);

    // Here we concatenate the pid with "/proc/" and
    // "/maps" to create the path of the file to read
    char* file_path = (char*)malloc(strlen("/proc/") + strlen(pid_string) + strlen("/maps") + 1);
    strcpy(file_path, "/proc/");
    strcat(file_path, pid_string);
    strcat(file_path, "/maps");

    // Check that we are able to open the maps file
    FILE* maps_file  = fopen(file_path, "r");
    if(maps_file == NULL)
    {
        exit(-1);
    }

    char * line = NULL;
    size_t len = 0;
    ssize_t read;

    // For each entry in the maps file, if we
    // find the "jdwp" string, we are debugged!
    while((read = getline(&line, &len, maps_file)) != -1)
    {
        if(strstr(line, "jdwp") != NULL)
        {
            // By parsing the line, we retrieve the starting and
            // ending addresses and permissions of the memory page
            char * temp;

            temp = strtok(line, "-");
            char starting_address_hex_char[strlen(temp) + 1];
            strncpy(starting_address_hex_char, temp, strlen(temp) + 1);

            temp = strtok(NULL, " ");
            char ending_address_hex_char[strlen(temp) + 1];
            strncpy(ending_address_hex_char, temp, strlen(temp) + 1);

            temp = strtok(NULL, " ");
            char permission_read  = temp[0];
            char permission_write = temp[1];
            char permission_exec  = temp[2];

            // We are interested in tampering only the memory page with the
            // 'x' permission, i.e., the memory page with executable code.
            // Indeed, we want our AD protection to be as stealthy as possible
            if(permission_exec == 'x')
            {
                // parse the starting and ending addresses and permissions of the memory page to base 10
                long starting_address_number    = strtol(starting_address_hex_char, NULL, 16);
                long ending_address_number      = strtol(ending_address_hex_char, NULL, 16);
                long difference_address_number  = ending_address_number - starting_address_number;
                char* starting_address         = (char*)starting_address_number;
                char* ending_address           = (char*)ending_address_number;

                // Change the flags to be able to write on the memory page to overwrite the code of the debugger.
                // If there were errors in modifying the flags, something is off
                if(mprotect(starting_address, difference_address_number, PROT_READ | PROT_WRITE | PROT_EXEC) == -1)
                {
                    exit(-1);
                }
                long i;
                uint8_t* loop_address = (uint8_t*)starting_address;

                // For each byte in the memory page, check whether the byte is the beginning of
                // a function (i.e., the opcode is 0x55 in hex, 85 in dec => 'push rbp'). If so,
                // then overwrite it with the return opcode (0XC3 in hex, 195 in dec)
                for(i = 0; i < difference_address_number; i = i + 1l)
                {
                     uint8_t byte8 = *loop_address;
                     if(byte8 == 0x55)
                     {
                        *loop_address = 0xC3;
                        protection_applied = 1;
                     }
                     loop_address++;
                }
                // Restore the permission flags of the memory page
                // 5 is '101', that maps in r-x (so read and execute but not write)
                // If there were errors in modifying the flags, something is off
                if (mprotect(starting_address, difference_address_number, 5) == -1)
                {
                    exit(-1);
                }
            }
            // This condition is true if we did NOT apply the protection
            if(protection_applied == 0)
            {
                exit(-1);
            }
        }
    }
    fclose(maps_file);
    return;
}