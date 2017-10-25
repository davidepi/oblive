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

void test02_apkjartools_extractapkjar(void **state)
{
    int res = extract_apkjar(NULL, NULL);
    assert_int_equal(res, ZIP_ERROR_NULL_INPUT);
    
    SAFE_CREATE_DIR(TESTS_RES_PATH "app-debug.apk.content/");
    res = extract_apkjar(TESTS_RES_PATH "app-debug.apk",
                         NULL);
    assert_int_equal(res, ZIP_ERROR_OUTPUT_ALREADY_EXISTENT);
    rmdir(TESTS_RES_PATH "app-debug.apk.content/");
    
    res = extract_apkjar(TESTS_RES_PATH "app-debug.apk",
                         TESTS_RES_PATH "random");
    assert_int_equal(res, ZIP_ERROR_OUTPUT_IS_NOT_A_FOLDER);
    
    res = extract_apkjar(TESTS_RES_PATH "app-debug.apk",
                         TESTS_RES_PATH "random/");
    assert_int_equal(res, ZIP_ERROR_OUTPUT_FOLDER_DOES_NOT_EXISTS);
    
    res = extract_apkjar(TESTS_RES_PATH "spanned.apk",
                         NULL);
    assert_int_equal(res, ZIP_SPANNED_ARCHIVE);
    
    UNREADABLE_CHMOD(TESTS_RES_PATH "exists/");
    res = extract_apkjar(TESTS_RES_PATH "app-debug.apk",
                         TESTS_RES_PATH "exists/");
    assert_int_equal(res, ZIP_ERROR_OUTPUT_NOT_WRITABLE);
    DEFAULT_CHMOD(TESTS_RES_PATH "exists/");
}

void test03_apkjartools_extractapkjar_fullrun(void** state)
{
#define EX EXISTS
#define TRP TESTS_RES_PATH
#define PS PATH_SEPARATOR_STRING
    
    int res = extract_apkjar(TRP "app-debug.apk", NULL);
    assert_true(EX(TRP "app-debug.apk.content" PS "AndroidManifest.xml"));
    unlink(TRP "app-debug.apk.content" PS "AndroidManifest.xml");
    assert_true(EX(TRP "app-debug.apk.content" PS "classes.dex"));
    unlink(TRP "app-debug.apk.content" PS "classes.dex");
    assert_true(EX(TRP "app-debug.apk.content" PS "resources.arsc"));
    unlink(TRP "app-debug.apk.content" PS "resources.arsc");
    assert_true(EX(TRP "app-debug.apk.content" PS "META-INF" PS));
    assert_true(EX(TRP "app-debug.apk.content" PS "META-INF" PS "CERT.RSA"));
    unlink(TRP "app-debug.apk.content" PS "META-INF" PS "CERT.RSA");
    assert_true(EX(TRP "app-debug.apk.content" PS "META-INF" PS "CERT.SF"));
    unlink(TRP "app-debug.apk.content" PS "META-INF" PS "CERT.SF");
    assert_true(EX(TRP "app-debug.apk.content" PS "META-INF" PS "MANIFEST.MF"));
    unlink(TRP "app-debug.apk.content" PS "META-INF" PS "MANIFEST.MF");
    rmdir(TRP "app-debug.apk.content" PS "META-INF" PS);
    rmdir(TRP "app-debug.apk.content" PS);
    
#undef EX
#undef TRP
#undef PS
}
