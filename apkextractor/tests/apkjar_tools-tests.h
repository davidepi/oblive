#ifndef __APKJAR_TOOLS_TESTS_H__
#define __APKJAR_TOOLS_TESTS_H__

#include <stdarg.h>
#include <stddef.h>
#include <setjmp.h>
#include <cmocka.h>

#include <sys/stat.h>
#include "apkjar_tools.h"

void test00_apkjartools_existence(void **state);
void test01_apkjartools_signature(void **state);
void test02_apkjartools_extractapkjar(void **state);
void test03_apkjartools_extractapkjar_fullrun(void **state);

#endif