package it.se.obfuscator.tests.fields;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;

public class TestGetFieldInt extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.fields.GetFieldInt.class;
    private String[] methodTest = {"getField"};
    private Class[][] methodParam = {new Class[]{int.class}};
    private Object[][] methodArgs = {new Object[]{18}};


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
        return 1;
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
