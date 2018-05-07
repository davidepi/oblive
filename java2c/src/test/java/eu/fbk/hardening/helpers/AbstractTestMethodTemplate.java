package eu.fbk.hardening.helpers;

import eu.fbk.hardening.JavaToC;
import eu.fbk.hardening.JavaToC;
import org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.Assert.fail;

public abstract class AbstractTestMethodTemplate extends AbstractTransformationTest
{

    private final String inputClassDir = "build/classes/java/test";
    private final String copiedClassDir = "build/transformedclasses";
    private final String outputLibDir = "build/libsrc";

    @Override
    public String getAnnotatedFieldName(int position)
    {
        return "";
    }

    @Override
    public int getAnnotatedFieldSize()
    {
        return 0;
    }

    @Override
    public boolean changesBeyondAnnotatedMethods()
    {
        return false;
    }

    @Override
    public String getAnnotatedMethodName(int position)
    {
        return this.getTestMethodName(position);
    }

    @Override
    public int getAnnotatedMethodSize()
    {
        return this.getTestMethodSize();
    }

    @Override
    public Class<?>[] getAnnotatedMethodParams(int position)
    {
        return this.getTestMethodParams(position);
    }

    @Override
    public String getSourceDir()
    {
        return this.inputClassDir;
    }

    @Override
    public String getDestDir()
    {
        return this.copiedClassDir;
    }

    @Override
    public void transformClass()
    {
        String libname = this.getTestClass().toString().replaceFirst("class\\s","");
        String className = libname.replaceAll("\\.","/")+".class";
        try //tranformation
        {
            JavaToC.parseClass(this.getDestDir()+"/"+className,this.outputLibDir,libname);
        } catch (IOException e)
        {
            fail("Transformation failed");
            e.printStackTrace();
        }

        try //building
        {
            ProcessBuilder makefileRun;
            makefileRun = new ProcessBuilder("make","SRCDIR="+this.outputLibDir,"OUTDIR="+this.outputLibDir,
                    "SRCNAME="+libname,"LIBNAME="+libname);
            makefileRun.inheritIO();
            makefileRun.directory(new File(Paths.get(".").toAbsolutePath().toString()));
            Process child = makefileRun.start();
            child.waitFor();
            if(child.exitValue()!=0)
                fail("C Compiler error");
        } catch (InterruptedException | IOException e)
        {
            fail("C compilation failed");
            e.printStackTrace();
        }
    }
}
