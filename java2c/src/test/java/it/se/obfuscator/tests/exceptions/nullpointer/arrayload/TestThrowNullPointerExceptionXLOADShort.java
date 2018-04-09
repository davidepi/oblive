package it.se.obfuscator.tests.exceptions.nullpointer.arrayload;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;
import testclasses.exceptions.nullpointer.SupportClassShort;

public class TestThrowNullPointerExceptionXLOADShort extends AbstractTestMethodTemplate
{
    private Class<?> className = testclasses.exceptions.nullpointer.arrayload.ThrowNullPointerExceptionXLOADShort.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{SupportClassShort.class}};
    private Object[][] methodArgs = {new Object[]{new SupportClassShort()}};

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
