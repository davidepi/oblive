#ifndef __APKJAR_TOOLS_TESTS_H__
#define __APKJAR_TOOLS_TESTS_H__

#include <stdarg.h>
#include <stddef.h>
#include <setjmp.h>
#include <cmocka.h>

void testfunction_success(void **state);
void testfunction_fail(void **state);

#endif
