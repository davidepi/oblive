package it.se.obfuscator.tests.invoke.invokevirtual;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;

public class TestInvokeVirtualDouble extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.invoke.invokevirtual.InvokeVirtualDouble.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{double.class,double.class}};
    private Object[][] methodArgs = {new Object[]{3.14159265359,2.7182818284}};


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
