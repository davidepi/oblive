package it.se.obfuscator.tests.invoke.invokevirtual;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;

public class TestInvokeVirtualInt extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.invoke.invokevirtual.InvokeVirtualInt.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{int.class,int.class}};
    private Object[][] methodArgs = {new Object[]{1000000,-2000000}};


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
