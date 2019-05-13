package eu.fbk.hardening.helpers;

import eu.fbk.hardening.JavaToC;
import eu.fbk.hardening.support.NativeCompiler;
import eu.fbk.hardening.support.SystemInfo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.Assert.fail;

public abstract class AbstractTestMethodTemplate extends AbstractTransformationTest {

    private final String inputClassDir = "build"+File.separator+"classes"+File.separator+"java"+File.separator+"test";
    private final String copiedClassDir = "build"+File.separator+"transformedclasses";
    private final String outputLibDir = "build"+File.separator+"libsrc";

    @Override
    public String getAnnotatedFieldName(int position) {
        return "";
    }

    @Override
    public int getAnnotatedFieldSize() {
        return 0;
    }

    @Override
    public boolean changesBeyondAnnotatedMethods() {
        return false;
    }

    @Override
    public String getAnnotatedMethodName(int position) {
        return this.getTestMethodName(position);
    }

    @Override
    public int getAnnotatedMethodSize() {
        return this.getTestMethodSize();
    }

    @Override
    public Class<?>[] getAnnotatedMethodParams(int position) {
        return this.getTestMethodParams(position);
    }

    @Override
    public String getSourceDir() {
        return this.inputClassDir;
    }

    @Override
    public String getDestDir() {
        return this.copiedClassDir;
    }

    @Override
    public void transformClass() {
        String libname = this.getTestClass().toString().replaceFirst("class\\s", "");
        String className = libname.replaceAll("\\.", "/") + ".class";
        JavaToC j2c = new JavaToC();
        try //tranformation
        {
            j2c.startParsing(this.outputLibDir, libname);
            j2c.parseClass(this.getDestDir() + "/" + className);
            j2c.endParsing();
        } catch (IOException e) {
            fail("Transformation failed");
            e.printStackTrace();
        }

        //building
        NativeCompiler compiler = new NativeCompiler();
        File[] sources = new File[]{new File(this.outputLibDir+File.separator+libname+".c")};
        File destObj = new File(this.outputLibDir+File.separator+libname+SystemInfo.getObjectExtension());
        File destLib = new File(this.outputLibDir+File.separator+"lib"+libname+SystemInfo.getSharedLibraryExtension());
        String error;
        try {
            error = compiler.compileFile(sources, destObj);
            if(error == null) {
                error = compiler.compileSharedLib(new File[]{destObj}, destLib);
                if(error != null) {
                    fail(error);
                }
            } else {
                fail(error);
            }
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }
}
