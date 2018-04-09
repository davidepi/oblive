package it.se.obfuscator.tests.exceptions.nullpointer.arrayload;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;
import testclasses.exceptions.nullpointer.SupportClassChar;

public class TestCatchNullPointerExceptionXLOADChar extends AbstractTestMethodTemplate
{
    private Class<?> className = testclasses.exceptions.nullpointer.arrayload.CatchNullPointerExceptionXLOADChar.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{SupportClassChar.class}};
    private Object[][] methodArgs = {new Object[]{new SupportClassChar()}};

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
