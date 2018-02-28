package it.se.obfuscator.tests;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;

public class TestInvokeVirtualFloat extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.InvokeVirtualFloat.class;
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
