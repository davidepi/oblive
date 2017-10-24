#include "windows_defines.h"
#include "utility_macros.h"
#include<stdio.h>
#include<zip.h>
#include<string.h> //strcat, strcpy
#include<fcntl.h> //open

#define BLOCK_SIZE 4096

#define ZIP_OK 0
#define ZIP_ERROR_NULL_INPUT -1
#define ZIP_ERROR_INPUT_NOT_FOUND -2
#define ZIP_ERROR_INPUT_NOT_READABLE -3
#define ZIP_ERROR_OUTPUT_ALREADY_EXISTENT -4
#define ZIP_ERROR_OUTPUT_NOT_WRITABLE -5
#define ZIP_ERROR_UNABLE_TO_OPEN_ZIP -6
#define ZIP_ERROR_ZIP_EXTRACTION_FAILED -7
#define ZIP_ERROR_SAVING_EXTRACTED_FILES -8
#define ZIP_ERROR_UNABLE_TO_READ_ZIP_CONTENT -9

int extract_apkjar(const char* input, const char* output);
