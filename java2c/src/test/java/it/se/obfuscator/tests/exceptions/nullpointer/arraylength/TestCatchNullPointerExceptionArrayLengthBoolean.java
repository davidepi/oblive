package it.se.obfuscator.tests.exceptions.nullpointer.arraylength;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;
import testclasses.exceptions.nullpointer.SupportClassBoolean;

public class TestCatchNullPointerExceptionArrayLengthBoolean extends AbstractTestMethodTemplate
{
    private Class<?> className = testclasses.exceptions.nullpointer.arraylength.CatchNullPointerExceptionArrayLengthBoolean.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{SupportClassBoolean.class}};
    private Object[][] methodArgs = {new Object[]{new SupportClassBoolean()}};

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
