package it.se.obfuscator.tests.exceptions;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;

public class TestThrowExceptionInNew extends AbstractTestMethodTemplate
{
    private Class<?> className = testclasses.exceptions.ThrowExceptionInNew.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{}};
    private Object[][] methodArgs = {new Object[]{}};

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