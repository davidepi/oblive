#include<stdlib.h>
#include "windows_defines.h"
#define FATAL_ERROR(msg) {fprintf(stderr,msg CR);exit(EXIT_FAILURE);}
#define FATAL_PERROR(msg) {perror(msg);exit(EXIT_FAILURE);}
#define ERROR_AND_RETURN(msg,retcode) {printf(stderr,msg CR);return retcode;}
#define PERROR_AND_RETURN(msg,retcode) {perror(msg);return retcode;}
#define SAFE_CREATE_DIR(p) if(MKDIR(p)<0)FATAL_PERROR("Error creating folder");
