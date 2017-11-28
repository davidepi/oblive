package it.se.obfuscator.helpers;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public abstract class TestMethodTemplate
{
    @BeforeClass
    public static void convert_classes()
    {
        try
        {
            ClassConverter.convertAll();
        } catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void TestMethod()
    {
        try
        {
            runOriginalCode();
            runConvertedCode();
        }
        catch(IOException|ClassNotFoundException|IllegalAccessException|InstantiationException|NoSuchMethodException|InvocationTargetException e)
        {
            e.printStackTrace();
        }
    }

    private void runOriginalCode() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException
    {
        ClassLoader defaultClassLoader = this.getClass().getClassLoader();
        Class<?> testClass;
        testClass = defaultClassLoader.loadClass(getTestClassName());
        Object classInstance = testClass.newInstance();
        Method classMethod = testClass.getMethod(getMethodName(),getMethodParamsSignature());
        Object methodResult = classMethod.invoke(classInstance, getMethodParams());
        assertEquals(getMethodExpectedResult(),methodResult);
    }

    private void runConvertedCode() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException
    {
        URL transformed = new URL("file://" + (new File("build/convertedclasses/test/").getAbsolutePath()) + "/");
        URL[] urls = {transformed};
        // should be parent last class loader
        String[] transformedClasses = {getTestClassName()};
        ClassLoader defaultClassLoader = this.getClass().getClassLoader();
        ConvertedClassLoader newLoader = new ConvertedClassLoader(urls, defaultClassLoader, transformedClasses);
        Class<?> testClass;
        testClass = newLoader.loadClass(transformedClasses[0]);
        Object classInstance = testClass.newInstance();
        Method classMethod = testClass.getMethod(getMethodName(),getMethodParamsSignature());
        Object methodResult = classMethod.invoke(classInstance, getMethodParams());
        newLoader.close();
        assertEquals(getMethodExpectedResult(),methodResult);
    }

    public abstract String getTestClassName();
    public abstract String getMethodName();
    public abstract Class[] getMethodParamsSignature();
    public abstract Object[] getMethodParams();
    public abstract Object getMethodExpectedResult();
    public abstract boolean isStaticMethod();
}
