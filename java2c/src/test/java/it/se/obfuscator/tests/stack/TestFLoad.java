package it.se.obfuscator.tests.stack;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;

public class TestFLoad extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.stack.FLoad.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{float.class}};
    private Object[][] methodArgs = {new Object[]{3.5f}};


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
