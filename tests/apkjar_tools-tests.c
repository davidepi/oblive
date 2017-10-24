#include "apkjar_tools-tests.h"

void testfunction_success(void **state)
{
    assert_int_equal(0, 0);
}

void testfunction_fail(void **state)
{
    assert_int_equal(0,10);
}
