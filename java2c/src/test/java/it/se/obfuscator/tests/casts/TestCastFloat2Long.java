package it.se.obfuscator.tests.casts;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;

public class TestCastFloat2Long extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.casts.CastFloat2Long.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{float.class}};
    private Object[][] methodArgs = {new Object[]{3.25f}};


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
