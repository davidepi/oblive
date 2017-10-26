#include "utility_macros.h"
#include "apkjar_tools.h"
int main(int argc, char* argv[])
{
    //check argv[1]
    if(argc < 2)
        FATAL_ERROR("First command line argument should be the .apk name");
    int res = extract_apkjar(argv[1],0x0);
    if(res<0)
        print_zip_error(res, 1);
}
