package it.se.obfuscator.tests.arrays;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;

public class TestLoadArrayIntMultiDim extends AbstractTestMethodTemplate
{
    private Class<?> className = testclasses.arrays.LoadArrayIntMultiDim.class;
    private String[] methodTest = {"getVal"};
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
