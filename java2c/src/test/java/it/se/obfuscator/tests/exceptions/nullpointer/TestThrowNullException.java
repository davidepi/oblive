package it.se.obfuscator.tests.exceptions.nullpointer;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;

import java.io.File;

public class TestThrowNullException extends AbstractTestMethodTemplate
{
    private Class<?> className = testclasses.exceptions.nullpointer.ThrowNullException.class;
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