package it.se.obfuscator.tests.arithmetic;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;

public class TestLAdd extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.arithmetic.LAdd.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{long.class,long.class}};
    private Object[][] methodArgs = {new Object[]{15000000000L,21000000000L}};


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
