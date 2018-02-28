package it.se.obfuscator.tests.invoke.invokestatic;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;

public class TestInvokeStaticByte extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.invoke.invokestatic.InvokeStaticByte.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{byte.class,byte.class}};
    private Object[][] methodArgs = {new Object[]{(byte)15,(byte)18}};


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
