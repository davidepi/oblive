package it.se.obfuscator.tests.arrays.multidimensional;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;

public class TestNewArrayByteThreeDims extends AbstractTestMethodTemplate
{
    private Class<?> className = testclasses.arrays.multidimensional.NewArrayByteThreeDims.class;
    private String[] methodTest = {"test"};
    private Class[][] methodParam = {new Class[]{}};
    private Object[][] methodArgs = {new Object[]{}};

    @Override
    public String getAnnotatedMethodName(int position)
    {
        return "getArray";
    }

    @Override
    public int getAnnotatedMethodSize()
    {
        return 1;
    }

    @Override
    public Class<?>[] getAnnotatedMethodParams(int position)
    {
        return new Class[]{};
    }

    @Override
    public Class<?> getTestClass()
    {
        return className;
    }

    @Override
    public String getTestMethodName(int position)
    {
        return methodTest[position];
    }

    @Override
    public int getTestMethodSize()
    {
        return methodTest.length;
    }

    @Override
    public Class<?>[] getTestMethodParams(int position)
    {
        return methodParam[position];
    }

    @Override
    public Object[] getTestMethodArgs(int position)
    {
        return methodArgs[position];
    }
}
