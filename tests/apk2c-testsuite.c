#include <stdarg.h>
#include <stddef.h>
#include <setjmp.h>
#include <cmocka.h>

#include "utility_macros.h"
#include "apkjar_tools-tests.h"

int main(int argc, char* argv[])
{
#ifndef TESTS_RES_PATH
    FATAL_ERROR("Could not find directory containing test resources");
#endif
    const struct CMUnitTest tests[] = {
        cmocka_unit_test(test00_apkjartools_existence),
        cmocka_unit_test(test01_apkjartools_signature),
    };
    return cmocka_run_group_tests(tests, NULL, NULL);
}
