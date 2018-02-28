package it.se.obfuscator.tests;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;

public class TestInvokeVirtualLong extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.InvokeVirtualLong.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{long.class,long.class}};
    private Object[][] methodArgs = {new Object[]{0x200000001L,0x400000002L}};


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
