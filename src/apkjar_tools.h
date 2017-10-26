#ifndef __APKJAR_TOOLS_H__
#define __APKJAR_TOOLS_H__

#include "windows_defines.h"
#include "utility_macros.h"
#include <stdio.h>
#include <zip.h>
#include <string.h> //strcat, strcpy
#include <fcntl.h> //open
#include <stddef.h> //NULL

#define BLOCK_SIZE 4096

#define ZIP_EMPTY_ARCHIVE 1
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
#define ZIP_ERROR_TRUNCATED_FILE -10
#define ZIP_ERROR_WRONG_SIGNATURE -11
#define ZIP_SPANNED_ARCHIVE -12
#define ZIP_ERROR_OUTPUT_IS_NOT_A_FOLDER -13
#define ZIP_ERROR_OUTPUT_FOLDER_DOES_NOT_EXISTS -14

int check_existence(const char* input);
int check_signature(const char* input);
int extract_apkjar(const char* input, const char* output);
void print_zip_error(int code, char fatal);

#endif
