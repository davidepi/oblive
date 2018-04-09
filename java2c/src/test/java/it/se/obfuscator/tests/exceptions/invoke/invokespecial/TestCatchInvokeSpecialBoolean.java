package it.se.obfuscator.tests.exceptions.invoke.invokespecial;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;

public class TestCatchInvokeSpecialBoolean extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.exceptions.invoke.invokespecial.CatchInvokeSpecialBoolean.class;
    private String[] methodTest = {"and"};
    private Class[][] methodParam = {new Class[]{boolean.class,boolean.class}};
    private Object[][] methodArgs = {new Object[]{false,false}};

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
