#include "utility_macros.h"
#include "apkjar_tools.h"
#include "dex2jar.h"

int main(int argc, char* argv[])
{
    //check argv[1]
    if(argc < 3)
        FATAL_ERROR("Usage: ./apk2c <path to lib directory> <.apk>");
    
    char* dexfile = (char*)malloc(sizeof(char)*(strlen(argv[2])+21));
    char* jarfile = (char*)malloc(sizeof(char)*(strlen(argv[2])+21));
    strcpy(dexfile,argv[2]);
    strcpy(jarfile,argv[2]);
    strcat(dexfile,".content/classes.dex");
    strcat(jarfile,".content/classes.jar");
    
    int res = extract_apkjar(argv[2],NULL);
    if(res<0)
        print_apkjar_error(res, 1);
    
    dex2jar(argv[1], dexfile, jarfile);
    
    res = extract_apkjar(jarfile, NULL);
    if(res<0)
        print_apkjar_error(res, 1);
}
