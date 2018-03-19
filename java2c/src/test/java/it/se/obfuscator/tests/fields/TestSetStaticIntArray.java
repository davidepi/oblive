package it.se.obfuscator.tests.fields;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;

public class TestSetStaticIntArray extends AbstractTestMethodTemplate
{
    private Class<?> className = testclasses.fields.SetStaticIntArray.class;
    private String[] methodTest = {"test"};
    private Class[][] methodParam = {new Class[]{int[].class}};
    private Object[][] methodArgs = {new Object[]{new int[10]}};

    @Override
    public String getAnnotatedMethodName(int position)
    {
        return "setArray";
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
