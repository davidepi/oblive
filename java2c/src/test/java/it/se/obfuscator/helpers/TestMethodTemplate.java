package it.se.obfuscator.helpers;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public abstract class TestMethodTemplate
{

    @Test
    public void testMethod() throws IllegalAccessException, InvocationTargetException, IOException, InstantiationException, NoSuchMethodException, ClassNotFoundException, InterruptedException
    {
        transformClass(getTestClassName());
        runOriginalCode();
        runConvertedCode();
    }

    private void transformClass(final String classname) throws IOException, InterruptedException
    {
        String classNameSlash = classname.replace('.','/')+".class";
        ClassTransformer.transform(classNameSlash);
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
        URL transformed = new URL("file://" + (new File("build/transformedclasses/test/").getAbsolutePath()) + "/");
        URL[] urls = {transformed};
        // should be parent last class loader
        String[] transformedClasses = {getTestClassName()};
        ClassLoader defaultClassLoader = this.getClass().getClassLoader();
        TransformedClassLoader newLoader = new TransformedClassLoader(urls, defaultClassLoader, transformedClasses);
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
}
