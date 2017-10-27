#include "dex2jar.h"

//global, but this check must be perfomed only once
char lib_added = 0;

static void check_dex2jar_lib(const char* arg1)
{
#define PATH_LENGTH 256
    
    char path[PATH_LENGTH];
    char* concat;
    int res = 0;
    strncpy(path, arg1, PATH_LENGTH);
    
    //add the / at the end of the directory
    if(arg1[strlen(arg1)-1]!=PATH_SEPARATOR_CHAR)
        strncat(path,PATH_SEPARATOR_STRING,PATH_LENGTH);
    
    //calculate new pointer starting from end of arg1
    int pathlen = (int)strlen(path);
    concat = path+pathlen;
    //new value for strncat starting from `concat`
    int max_characters = PATH_LENGTH-pathlen;
    
    
    strncat(concat,"antlr-runtime-3.5.jar",max_characters);
    if(EXISTS(path))
        res++;
    concat[0] = '\0';
    strncat(concat,"asm-debug-all-4.1.jar",max_characters);
    if(EXISTS(path))
        res++;
    concat[0] = '\0';
    strncat(concat,"d2j-base-cmd-2.0.jar",max_characters);
    if(EXISTS(path))
        res++;
    concat[0] = '\0';
    strncat(concat,"d2j-jasmin-2.0.jar",max_characters);
    if(EXISTS(path))
        res++;
    concat[0] = '\0';
    strncat(concat,"d2j-smali-2.0.jar",max_characters);
    if(EXISTS(path))
        res++;
    concat[0] = '\0';
    strncat(concat,"dex-ir-2.0.jar",max_characters);
    if(EXISTS(path))
        res++;
    concat[0] = '\0';
    strncat(concat,"dex-reader-2.0.jar",max_characters);
    if(EXISTS(path))
        res++;
    concat[0] = '\0';
    strncat(concat,"dex-reader-api-2.0.jar",max_characters);
    if(EXISTS(path))
        res++;
    concat[0] = '\0';
    strncat(concat,"dex-tools-2.0.jar",max_characters);
    if(EXISTS(path))
        res++;
    concat[0] = '\0';
    strncat(concat,"dex-translator-2.0.jar",max_characters);
    if(EXISTS(path))
        res++;
    concat[0] = '\0';
    strncat(concat,"dex-writer-2.0.jar",max_characters);
    if(EXISTS(path))
        res++;
    concat[0] = '\0';
    strncat(concat,"dx-1.7.jar",max_characters);
    if(EXISTS(path))
        res++;
    if(res==12)
        lib_added = 1;
    else
        FATAL_ERROR("Missing dex2jar library");
}

void dex2jar(const char* argv1, const char* dexfile)
{
    if(!lib_added)
        check_dex2jar_lib(argv1);
}
