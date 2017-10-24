#include <stdarg.h>
#include <stddef.h>
#include <setjmp.h>
#include <cmocka.h>

#include "apkjar_tools-tests.h"

int main(int argc, char* argv[])
{
    const struct CMUnitTest tests[] = {
        cmocka_unit_test(testfunction_success),
        cmocka_unit_test(testfunction_fail),
    };
    return cmocka_run_group_tests(tests, NULL, NULL);
}
