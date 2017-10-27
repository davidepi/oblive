#include "apkjar_tools.h"

//check if the file exists
int check_existence_apkjar(const char* input)
{
    if(!EXISTS(input))
        return ZIP_ERROR_INPUT_NOT_FOUND;
    else
        return ZIP_OK;
}
//check if the file is readable and if it is a zip/apk/jar file
int check_signature_apkjar(const char* input)
{
    int res = check_existence_apkjar(input);
    int fd;
    uint8_t values[4];
    if(res != ZIP_OK)
        return res;
    if(!READABLE(input) || ((fd = FD_RO_BINARY(input))==-1))
        return ZIP_ERROR_INPUT_NOT_READABLE;
    uint8_t len = read(fd,values,4);
    close(fd);
    if(len<4)
        return ZIP_ERROR_TRUNCATED_FILE;
    if(values[0]==0x50 && values[1]==0x4B)
    {
        if(values[2] == 0x03 && values[3] == 0x04)
            return ZIP_OK;
        else if(values[2]==0x05 && values[3]==0x06)
            return ZIP_EMPTY_ARCHIVE;
        else if(values[2] == 0x07 && values[3] == 0x08)
            return ZIP_SPANNED_ARCHIVE;
        else
            return ZIP_ERROR_WRONG_SIGNATURE;
    }
    else
        return ZIP_ERROR_WRONG_SIGNATURE;
}

int extract_apkjar(const char* input, const char* output)
{
    char* folder;
    if(input == NULL)//otherwise strlen(output) will break
        return ZIP_ERROR_NULL_INPUT;
    if(output == NULL)
    {
        //create filename.apk.content strings
        char FOLDER_EXT[] = ".content";
        //2 because of / (or \) and \0
        const int FOLDER_LEN = (int)(strlen(input)+strlen(FOLDER_EXT)+2);
        folder = (char*)malloc(sizeof(char)*FOLDER_LEN);
        strcpy(folder,input);
        strcat(folder,FOLDER_EXT);
        strcat(folder,PATH_SEPARATOR_STRING);
        
        if(EXISTS(folder))
            return ZIP_ERROR_OUTPUT_ALREADY_EXISTENT;
    }
    else
    {
        //check if output is actually a folder and existent
        if(output[strlen(output)-1]!=PATH_SEPARATOR_CHAR)
            return ZIP_ERROR_OUTPUT_IS_NOT_A_FOLDER;
        const int FOLDER_LEN = (int)(strlen(output)+1);
        folder = (char*)malloc(sizeof(char)*FOLDER_LEN);
        strcpy(folder,output);
        
        if(!WRITABLE(output))
            return ZIP_ERROR_OUTPUT_NOT_WRITABLE;
        else if(!EXISTS(output))
            SAFE_CREATE_DIR(output);
    }
    
    struct zip* za;
    struct zip_file* zf;
    struct zip_stat zs;
    
    int res = check_signature_apkjar(input);
    if(res < 0)
        return res;

    //create folder where the content will be extracted
    SAFE_CREATE_DIR(folder);

    //unzip .apk file
    int err,len,f;
    uint32_t wrote; //max filesize in a zip file is 4GB. uint32_t is enough
    const int BUFFER_SIZE = 512;
    //strtok wants a modifiable string. this one
    char name_copy_short[BUFFER_SIZE];
    //if zs.name is longer than the name_copy buffer, it will be stored here
    char* name_copy = 0x0;
    char name_copy_allocated = 0;
    char* ar_fold; //folders inside the archive
    char name[BUFFER_SIZE];
    uint8_t buffer[BLOCK_SIZE];
    za = zip_open(input, 0, &err);
    if(za == NULL)
        return ZIP_ERROR_UNABLE_TO_OPEN_ZIP;
    int i;
    for(i=0;i<zip_get_num_entries(za,0);i++) //for every zipped file
    {
        if(zip_stat_index(za,i,0,&zs)==0)
        {
            len = (int)strlen(zs.name);
            if(len+1>BUFFER_SIZE)
            {
                name_copy = (char*)malloc(sizeof(char)*(len+1));
                name_copy_allocated = 1;
            }
            else
                name_copy = name_copy_short;
            strcpy(name_copy,zs.name);
            strncpy(name,folder,BUFFER_SIZE);
            //tokenize string on path separator
            ar_fold = strtok(name_copy,"\n" PATH_SEPARATOR_STRING);
            do //recursively create folders
            {
                strncat(name,ar_fold,BUFFER_SIZE);
                strncat(name,PATH_SEPARATOR_STRING,BUFFER_SIZE);
                if(!EXISTS(name))
                    SAFE_CREATE_DIR(name);
            }
            while((ar_fold = strtok(NULL,"\n" PATH_SEPARATOR_STRING))!=NULL);
            rmdir(name); //remove last added folder, should be a file
            name[strlen(name)-1]='\0';//remove separator at the end of the path
            //the last entry should be a file, not a dir

            //extract file            
            zf = zip_fopen_index(za,i,0);
            if(!zf)
                return ZIP_ERROR_ZIP_EXTRACTION_FAILED;
            //open file description in write mode
            f = FD_WO_BINARY(name);
            if(f<0)
                return ZIP_ERROR_SAVING_EXTRACTED_FILES;

            wrote = 0;
            while(wrote < zs.size) //process content of the file
            {                     //writing BUFFER_SIZE bytes at time
                len = (int)zip_fread(zf,buffer,BLOCK_SIZE);
                if(len<0)
                    return ZIP_ERROR_UNABLE_TO_READ_ZIP_CONTENT;
                write(f,buffer,len);
                wrote+=len;
            }
            if(name_copy_allocated) //if the long name was allocated
            {
                //deallocate it
                free(name_copy);
                name_copy = NULL;
                name_copy_allocated = 0;
            }
            close(f);
            zip_fclose(zf);
        }
    }
    zip_close(za);
    return ZIP_OK;
    free(folder);
}
