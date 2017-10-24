#include<stdio.h>
#include<zip.h>
#include<string.h> //strcat, strcpy
#include<stdlib.h> //exit
#include<fcntl.h> //open
#include "windows_defines.h"
#define FATAL_ERR(msg) {fprintf(stderr,msg CR);exit(EXIT_FAILURE);}
#define FATAL_PERR(msg) {perror(msg);exit(EXIT_FAILURE);}
#define CREATE_DIR(p) {if(MKDIR(p)<0)FATAL_PERR("Error creating folder");}
int main(int argc, char* argv[])
{
    struct zip* za;
    struct zip_file* zf;
    struct zip_stat zs;
    //check argv[1]
    if(argc < 2)
        FATAL_ERR("First command line argument should be the .apk name");

    //create filename.apk.zip and filename.apk.zip.content strings
    char* FOLDER_EXT = ".content";
    //2 because of / (or \) and \0
    const int FOLDER_LEN = strlen(argv[1])+strlen(FOLDER_EXT)+2;
    char* folder = (char*)malloc(sizeof(char)*FOLDER_LEN);
    strcpy(folder,argv[1]);
    strcat(folder,FOLDER_EXT);
    strcat(folder,PATH_SEPARATOR_STRING);

    //assert filename.apk existance and filename.apk.zip and 
    //filename.apk.zip.content non-existance
    if(!EXISTS(argv[1]))
        FATAL_ERR("The input file does not exists");
    if(!READABLE(argv[1]))
        FATAL_ERR("The input file is not readable");
    if(EXISTS(folder))
        FATAL_ERR("The folder .apk.content/ already exists");
    
    //create folder where the content will be extracted
    CREATE_DIR(folder);
    
    //unzip .apk file
    int err,len,f;
    uint32_t wrote; //max filesize in a zip file is 4GB. uint32_t is enough
    const int BUFFER_SIZE = 512;
    char* ar_fold; //folders inside the archive
    char name[BUFFER_SIZE];//should be a good idea to split the two buffers size
    uint8_t buffer[BUFFER_SIZE];//nvm works anyway
    za = zip_open(argv[1], 0, &err);
    if(za == NULL)
        FATAL_ERR("Can't open zip archive");
    for(int i=0;i<zip_get_num_entries(za,0);i++) //for every zipped file
    {
        if(zip_stat_index(za,i,0,&zs)==0)
        {
            len = strlen(zs.name);
            strncpy(name,folder,BUFFER_SIZE);
            //tokenize string on path separator
            ar_fold = strtok(zs.name,"\n" PATH_SEPARATOR_STRING);
            do //recursively create folders
            {
                strncat(name,ar_fold,BUFFER_SIZE);
                strncat(name,PATH_SEPARATOR_STRING,BUFFER_SIZE);
                if(!EXISTS(name))
                    CREATE_DIR(name);
            }
            while((ar_fold = strtok(NULL,"\n" PATH_SEPARATOR_STRING))!=NULL);
            rmdir(name); //remove last added folder, should be a file
            name[strlen(name)-1]='\0';//remove separator at the end of the path
                                    //the last entry should be a file, not a dir
            
                //extract file            
                zf = zip_fopen_index(za,i,0);
                if(!zf)
                    FATAL_ERR("Zip extraction failed");
                //open file description in write mode
                f = FD_WR_BINARY(name);
                if(f<0)
                {
                    printf("%s\n",name);
                    FATAL_PERR("Error while saving zip content to disk");
                }

                wrote = 0;
                while(wrote < zs.size) //process content of the file
                {                     //writing BUFFER_SIZE bytes at time
                    len = zip_fread(zf,buffer,BUFFER_SIZE);
                    if(len<0)
                        FATAL_ERR("Error while reading zip content");
                    write(f,buffer,len);
                    wrote+=len;
                }
                close(f);
                zip_fclose(zf);
        }
    }
    zip_close(za);

    //delete temp folder
    //rmdir(folder);
    return 0;
}
