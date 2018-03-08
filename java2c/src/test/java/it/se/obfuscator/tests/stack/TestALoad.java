package it.se.obfuscator.tests.stack;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;

public class TestALoad extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.stack.ALoad.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{java.lang.String.class}};
    private Object[][] methodArgs = {new Object[]{"hello"}};


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
