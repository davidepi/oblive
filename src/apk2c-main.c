#include "utility_macros.h"
#include "apkjar_tools.h"
int main(int argc, char* argv[])
{
    //check argv[1]
    if(argc < 2)
        FATAL_ERROR("First command line argument should be the .apk name");
    return extract_apkjar(argv[1],0x0);
}
