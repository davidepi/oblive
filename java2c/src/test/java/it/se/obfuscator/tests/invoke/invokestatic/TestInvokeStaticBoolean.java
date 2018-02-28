package it.se.obfuscator.tests.invoke.invokestatic;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;

public class TestInvokeStaticBoolean extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.invoke.invokestatic.InvokeStaticBoolean.class;
    private String[] methodTest = {"and","and","and","and"};
    private Class[][] methodParam = {new Class[]{boolean.class,boolean.class},new Class[]{boolean.class,boolean.class},
                                     new Class[]{boolean.class,boolean.class},new Class[]{boolean.class,boolean.class}};
    private Object[][] methodArgs = {new Object[]{false,false},new Object[]{true,false},
                                     new Object[]{false,true},new Object[]{true,true}};


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
        return 4;
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
