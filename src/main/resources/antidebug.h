static inline void time_start(time_t* start)
{
    time(start);
}

static inline void time_check(time_t* start)
{
    if(difftime(time(NULL),*start)>0)
    {
        _exit(EXIT_SUCCESS);
    }
}

static inline void self_debug()
{
    pid_t parent_pid = getpid();
    pid_t child_pid = fork();
    if (child_pid == 0)
    {
        int true_child_pid = getpid();
        if (ptrace(PTRACE_SEIZE, parent_pid, NULL, NULL) != -1)
        {
        }
        else
        {
             _exit(EXIT_SUCCESS);
        }
    }
    else {
        if (prctl(PR_SET_PTRACER, child_pid) != -1) {
            // log
            //printf("parent: successfully used prctl PR_SET_PTRACER\n");
        }
        else {
            // log
            //printf("parent: error when using used prctl PR_SET_PTRACER\n");
        }
        int status;
        waitpid(child_pid, &status, 0);
        _exit(EXIT_SUCCESS);
    }

}