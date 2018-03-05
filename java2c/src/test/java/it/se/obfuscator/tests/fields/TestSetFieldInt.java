package it.se.obfuscator.tests.fields;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;

public class TestSetFieldInt extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.fields.SetFieldInt.class;
    private String[] methodTest = {"getField"};
    private Class[][] methodParam = {new Class[]{}};
    private Object[][] methodArgs = {new Object[]{}};
    private String[] annotatedMethod = {"setField"};
    private Class[][] annotatedParams = {new Class[]{int.class}};


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

    @Override
    public String getAnnotatedMethodName(int position)
    {
        return annotatedMethod[position];
    }

    @Override
    public int getAnnotatedMethodSize()
    {
        return this.annotatedMethod.length;
    }

    @Override
    public Class<?>[] getAnnotatedMethodParams(int position)
    {
        return this.annotatedParams[position];
    }
}
