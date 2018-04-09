package it.se.obfuscator.tests.exceptions.invoke.invokespecial;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;

public class TestCatchInvokeSpecialFloat extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.exceptions.invoke.invokespecial.CatchInvokeSpecialFloat.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{float.class,float.class}};
    private Object[][] methodArgs = {new Object[]{3.5f,-2.5f}};

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
