package it.se.obfuscator.tests.arrays.unidimensional;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;

public class TestStoreArrayChar extends AbstractTestMethodTemplate
{
    private Class<?> className = testclasses.arrays.unidimensional.StoreArrayChar.class;
    private String[] methodTest = {"test"};
    private Class[][] methodParam = {new Class[]{}};
    private Object[][] methodArgs = {new Object[]{}};

    @Override
    public String getAnnotatedMethodName(int position)
    {
        return "setVal";
    }

    @Override
    public int getAnnotatedMethodSize()
    {
        return 1;
    }

    @Override
    public Class<?>[] getAnnotatedMethodParams(int position)
    {
        return new Class[]{int.class,char.class};
    }

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
