package it.se.obfuscator.tests.exceptions.nullpointer.arraystore;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;
import testclasses.exceptions.nullpointer.SupportClassByte;

public class TestCatchNullPointerExceptionXSTOREByte extends AbstractTestMethodTemplate
{
    private Class<?> className = testclasses.exceptions.nullpointer.arraystore.CatchNullPointerExceptionXSTOREByte.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{SupportClassByte.class}};
    private Object[][] methodArgs = {new Object[]{new SupportClassByte()}};

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