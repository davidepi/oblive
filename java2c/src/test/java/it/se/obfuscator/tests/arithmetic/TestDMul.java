package it.se.obfuscator.tests.arithmetic;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;

public class TestDMul extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.arithmetic.DMul.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{double.class,double.class}};
    private Object[][] methodArgs = {new Object[]{3.5,2.5}};


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
