package it.oblive.helpers;

import it.oblive.JavaToC;
import it.oblive.support.CompilationException;
import it.oblive.support.NativeCompiler;
import it.oblive.support.SystemInfo;
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
        File outSource = new File(OUTPUT_LIB_DIR + File.separator + "lib" + libname + ".c");
        File outVM = new File(OUTPUT_LIB_DIR + File.separator + "lib" + libname + "vm.c");
        File outObject = new File(OUTPUT_LIB_DIR + File.separator + "lib" + libname + SystemInfo.getObjectExtension());
        File outObjectVM =
                new File(OUTPUT_LIB_DIR + File.separator + "lib" + libname + "vm" + SystemInfo.getObjectExtension());
        File outLib =
                new File(OUTPUT_LIB_DIR + File.separator + "lib" + libname + SystemInfo.getSharedLibraryExtension());
        JavaToC j2c = new JavaToC();
        try //tranformation
        {
            j2c.startParsing(outSource);
            j2c.parseClass(this.getDestDir() + File.separator + className);
            j2c.endParsing();
        } catch (IOException e) {
            Assertions.fail("Transformation failed");
            e.printStackTrace();
        }

        //building
        NativeCompiler compiler = new NativeCompiler();
        File[] sources = new File[]{outSource};
        String error;
        if (!outVM.exists()) {
            compiler.setCompilationFlags("-Wall -Wno-unused-variable -Wno-unused-function -O3");
        } else {
            // antidebug requested, this requires libcrypto
            compiler.setStaticLibs(new String[]{"libcrypto"});
            compiler.setCompilationFlags("-Wall -Wno-unused-variable -Wno-unused-function -O3");
        }
        try {
            compiler.compileFile(sources, outObject, false);
            compiler.compileSharedLib(new File[]{outObject}, outLib);
            if (outVM.exists()) {
                compiler.compileFile(new File[]{outVM}, outObjectVM, true);
            }
        } catch (IOException | InterruptedException | CompilationException e) {
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
