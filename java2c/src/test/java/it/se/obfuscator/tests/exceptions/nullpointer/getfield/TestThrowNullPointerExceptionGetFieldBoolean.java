package it.se.obfuscator.tests.exceptions.nullpointer.getfield;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;

public class TestThrowNullPointerExceptionGetFieldBoolean extends AbstractTestMethodTemplate
{
    private Class<?> className = testclasses.exceptions.nullpointer.getfield.ThrowNullPointerExceptionGetFieldBoolean.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{testclasses.exceptions.nullpointer.SupportClassBoolean.class}};
    private Object[][] methodArgs = {new Object[]{null}};

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
