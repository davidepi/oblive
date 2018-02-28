package it.se.obfuscator.tests.invoke.invokestatic;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;

public class TestInvokeStaticShort extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.invoke.invokestatic.InvokeStaticShort.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{short.class,short.class}};
    private Object[][] methodArgs = {new Object[]{(short)15000,(short)21000}};


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
