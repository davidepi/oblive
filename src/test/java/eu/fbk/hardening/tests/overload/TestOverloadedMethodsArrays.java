package eu.fbk.hardening.tests.overload;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;

public class TestOverloadedMethodsArrays extends AbstractTestMethodTemplate
{
    private Class<?> className = testclasses.overload.OverloadedMethodsArrays.class;
    private String[] methodTest = {"add", "add"};
    private Class[][] methodParam = {new Class[]{int.class, double.class}, new Class[]{String[].class, int[].class}};
    private Object[][] methodArgs = {new Object[]{15, 21}, new Object[]{new String[]{"15"},new int[]{36}}};

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
