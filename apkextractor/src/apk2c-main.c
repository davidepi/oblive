#include "utility_macros.h"
#include "apkjar_tools.h"
#include "dex2jar.h"

int main(int argc, char* argv[])
{
    //check argv[1]
    if(argc < 3)
        FATAL_ERROR("Usage: ./apk2c <path to lib directory> <.apk>");
    
    //path of the classes.dex file
    char* dexfile = (char*)malloc(sizeof(char)*(strlen(argv[2])+21));
    //path of the classes.jar file
    char* jarfile = (char*)malloc(sizeof(char)*(strlen(argv[2])+21));
    //path of the extracted classes.jar
    char* jarcontent = (char*)malloc(sizeof(char)*(strlen(argv[2])+30));
    strcpy(dexfile,argv[2]);
    strcpy(jarfile,argv[2]);
    strcat(dexfile,".content/classes.dex");
    strcat(jarfile,".content/classes.jar");
    strcpy(jarcontent,jarfile);
    strcat(jarcontent,".content/");
    
    int res = extract_apkjar(argv[2],NULL);
    if(res<0)
        print_apkjar_error(res, 1);
    
    dex2jar(argv[1], dexfile, jarfile);
    
    res = extract_apkjar(jarfile, NULL);
    if(res<0)
        print_apkjar_error(res, 1);
    
    char* cmd = (char*)malloc(sizeof(char)*(strlen(jarcontent)+97));
    strcpy(cmd,"java -jar dynamic-callgraph.jar $(find ");
    strcat(cmd,jarcontent);
    strcat(cmd," -name '*.class' -print | grep -v android/ | tr '\n' ' ')");
    chdir(argv[1]);
    res = system(cmd);
    if(res < 0)
        FATAL_ERROR("Error while processing .class files");
}
