#include "utility_macros.h"
#include "apkjar_tools.h"
#include "dex2jar.h"

int main(int argc, char* argv[])
{
    //check argv[1]
    if(argc < 3)
        FATAL_ERROR("Usage: ./apk2c <path to lib directory> <.apk>");
    
    //int res = extract_apkjar(argv[1],0x0);
    //if(res<0)
    //    print_apkjar_error(res, 1);
    
    dex2jar(argv[1], NULL);
}
