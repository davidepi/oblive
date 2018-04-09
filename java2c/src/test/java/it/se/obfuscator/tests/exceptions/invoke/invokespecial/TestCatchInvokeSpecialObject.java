package it.se.obfuscator.tests.exceptions.invoke.invokespecial;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;

public class TestCatchInvokeSpecialObject extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.exceptions.invoke.invokespecial.CatchInvokeSpecialObject.class;
    private String[] methodTest = {"concatenate"};
    private Class[][] methodParam = {new Class[]{String.class,char.class}};
    private Object[][] methodArgs = {new Object[]{"hello world",'!'}};

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
