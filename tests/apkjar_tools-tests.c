#include "apkjar_tools-tests.h"

void test00_apkjartools_existence(void **state)
{
    int res = check_existence(TESTS_RES_PATH "non-existent.apk");
    assert_int_equal(res, ZIP_ERROR_INPUT_NOT_FOUND);
    
    res = check_existence(TESTS_RES_PATH "app-debug.apk");
    assert_int_equal(res, ZIP_OK);
}

void test01_apkjartools_signature(void **state)
{
    int res = check_signature(TESTS_RES_PATH "changed_signature.apk");
    assert_int_equal(res, ZIP_ERROR_WRONG_SIGNATURE);
    
    res = check_signature(TESTS_RES_PATH "non-existent.apk");
    assert_int_equal(res, ZIP_ERROR_INPUT_NOT_FOUND);
    
    res = check_signature(TESTS_RES_PATH "empty.apk");
    assert_int_equal(res, ZIP_EMPTY_ARCHIVE);
    
    res = check_signature(TESTS_RES_PATH "truncated.apk");
    assert_int_equal(res, ZIP_ERROR_TRUNCATED_FILE);
    
    res = check_signature(TESTS_RES_PATH "spanned.apk");
    assert_int_equal(res, ZIP_SPANNED_ARCHIVE);
    
    res = check_signature(TESTS_RES_PATH "app-debug.apk");
    assert_int_equal(res, ZIP_OK);
    
    res = check_signature(TESTS_RES_PATH "half_correct_signature.apk");
    assert_int_equal(res,ZIP_ERROR_WRONG_SIGNATURE);
    
    UNREADABLE_CHMOD(TESTS_RES_PATH "app-debug.apk");
    res = check_signature(TESTS_RES_PATH "app-debug.apk");
    assert_int_equal(res, ZIP_ERROR_INPUT_NOT_READABLE);
    DEFAULT_CHMOD(TESTS_RES_PATH "app-debug.apk");
}
