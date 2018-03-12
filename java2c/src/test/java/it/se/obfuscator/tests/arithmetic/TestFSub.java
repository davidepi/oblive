package it.se.obfuscator.tests.arithmetic;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;

public class TestFSub extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.arithmetic.FSub.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{float.class,float.class}};
    private Object[][] methodArgs = {new Object[]{3.5f,0.5f}};


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
