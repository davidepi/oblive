#include "apkjar_tools.h"
#define ER(msg) fprintf(stderr,msg CR)

void print_zip_error(int code, char fatal)
{
    switch(code)
    {
        case ZIP_ERROR_NULL_INPUT:ER("Supplied input was a NULL pointer");break;
        case ZIP_ERROR_INPUT_NOT_FOUND:ER("File not found");break;
        case ZIP_ERROR_INPUT_NOT_READABLE:ER("File not readable. "\
                                             "Permission denied");break;
        case ZIP_ERROR_OUTPUT_ALREADY_EXISTENT:
            ER("Output folder is already existent, it won't be overwritten");
            break;
        case ZIP_ERROR_OUTPUT_NOT_WRITABLE:
            ER("Output folder not writable. Permission denied");break;
        case ZIP_ERROR_UNABLE_TO_OPEN_ZIP:
            ER("Unable to open archive");break;
        case ZIP_ERROR_ZIP_EXTRACTION_FAILED:
            ER("Zip extraction failed");break;
        case ZIP_ERROR_SAVING_EXTRACTED_FILES:
            ER("Error while saving extracted files. Is the disk full?");break;
        case ZIP_ERROR_UNABLE_TO_READ_ZIP_CONTENT:
            ER("Unable to read zip content");break;
        case ZIP_ERROR_TRUNCATED_FILE:
            ER("Input file signature is incomplete. Damaged file?");break;
        case ZIP_ERROR_WRONG_SIGNATURE:
            ER("The input file is not an apk or jar archive");break;
        case ZIP_SPANNED_ARCHIVE:
            ER("Multi-archive are unsupported");break;
        case ZIP_ERROR_OUTPUT_IS_NOT_A_FOLDER:
            ER("Output path is not a folder");break;
        case ZIP_ERROR_OUTPUT_FOLDER_DOES_NOT_EXISTS:
            ER("Output folder does not exits");break;
        default:return;
    }
    if(fatal)
        exit(EXIT_FAILURE);
}
