package it.se.obfuscator.tests.arithmetic;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;

public class TestIXor extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.arithmetic.IXor.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{int.class,int.class}};
    private Object[][] methodArgs = {new Object[]{11234567,2478945}};

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
