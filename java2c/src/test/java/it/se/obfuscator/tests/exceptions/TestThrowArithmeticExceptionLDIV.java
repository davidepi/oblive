package it.se.obfuscator.tests.exceptions;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;

public class TestThrowArithmeticExceptionLDIV extends AbstractTestMethodTemplate
{
    private Class<?> className = testclasses.exceptions.ThrowArithmeticExceptionLDIV.class;
    private String[] methodTest = {"divide"};
    private Class[][] methodParam = {new Class[]{long.class}};
    private Object[][] methodArgs = {new Object[]{10}};

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