package eu.fbk.hardening.helpers;

import eu.fbk.hardening.JavaToC;
import eu.fbk.hardening.support.NativeCompiler;
import eu.fbk.hardening.support.SystemInfo;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.IOException;

/**
 * This is the actual skeleton for the entire Java2C test suite. This skeleton implements a transformation method,
 * that is used to apply the Java2C obfuscation. Additional methods from the TestInterface interface which are always
 * the
 * same in Java2C are implemented here
 *
 * @author D.Pizzolotto
 */
public abstract class Java2CTests implements TestInterface {

    /**
     * Path to the classes that will be obfuscated (where the package structure starts)
     */
    private static final String INPUT_CLASS_DIR =
            "build" + File.separator + "classes" + File.separator + "java" + File.separator + "test";

    /**
     * Path to the folder where the classes will be copied
     */
    private static final String COPIED_CLASS_DIR = "build" + File.separator + "transformedclasses";

    /**
     * Path were the .so native code will be emitted
     */
    private static final String OUTPUT_LIB_DIR = "build" + File.separator + "libsrc";

    /**
     * Applies the Java2C obfuscation to a class
     */
    void transformAndBuild() {
        String libname = this.getTestClass().toString().replaceFirst("class\\s", "");
        String className = libname.replaceAll("\\.", "/") + ".class";
        JavaToC j2c = new JavaToC();
        try //tranformation
        {
            j2c.startParsing(OUTPUT_LIB_DIR, libname);
            j2c.parseClass(this.getDestDir() + "/" + className);
            j2c.endParsing();
        } catch (IOException e) {
            Assertions.fail("Transformation failed");
            e.printStackTrace();
        }

        //building
        NativeCompiler compiler = new NativeCompiler();
        File[] sources = new File[]{new File(OUTPUT_LIB_DIR + File.separator + libname + ".c")};
        File destObj = new File(OUTPUT_LIB_DIR + File.separator + libname + SystemInfo.getObjectExtension());
        File destLib =
                new File(OUTPUT_LIB_DIR + File.separator + "lib" + libname + SystemInfo.getSharedLibraryExtension());
        String error;
        try {
            error = compiler.compileFile(sources, destObj);
            if (error == null) {
                error = compiler.compileSharedLib(new File[]{destObj}, destLib);
                if (error != null) {
                    Assertions.fail(error);
                }
            } else {
                Assertions.fail(error);
            }
        } catch (IOException e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Override
    public String[] getAnnotatedFieldName() {
        //no annotated fields in java2c
        return new String[]{};
    }

    @Override
    public boolean changesBeyondAnnotatedMethods() {
        //false, even though the <clinit> changes... this has been fixed in the test template
        return false;
    }

    @Override
    public String[] getAnnotatedMethodName() {
        //usually the same of the test method, will be overrided by some tests
        return this.getTestMethodName();
    }

    @Override
    public Class<?>[][] getAnnotatedMethodParams() {
        //usually the same of the test method, will be overrided by some tests
        return this.getTestMethodParams();
    }

    @Override
    public String getSourceDir() {
        return INPUT_CLASS_DIR;
    }

    @Override
    public String getDestDir() {
        return COPIED_CLASS_DIR;
    }
}
