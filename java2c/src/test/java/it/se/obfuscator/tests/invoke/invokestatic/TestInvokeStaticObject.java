package it.se.obfuscator.tests.invoke.invokestatic;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;

public class TestInvokeStaticObject extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.invoke.invokestatic.InvokeStaticObject.class;
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
