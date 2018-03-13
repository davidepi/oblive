package it.se.obfuscator.tests.casts;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;

public class TestCastLong2Float extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.casts.CastLong2Float.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{long.class}};
    private Object[][] methodArgs = {new Object[]{10000000000L}};


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
