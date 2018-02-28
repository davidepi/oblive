package it.se.obfuscator.tests;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;

public class TestInvokeVirtualChar extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.InvokeVirtualChar.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{char.class,char.class}};
    private Object[][] methodArgs = {new Object[]{'A','b'}};


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
        return 1;
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
