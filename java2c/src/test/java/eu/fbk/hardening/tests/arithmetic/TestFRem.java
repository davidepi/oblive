package eu.fbk.hardening.tests.arithmetic;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;

public class TestFRem extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.arithmetic.FRem.class;
    private String[] methodTest = {"exec", "exec"};
    private Class[][] methodParam = {new Class[]{float.class, float.class}, new Class[]{float.class, float.class}};
    private Object[][] methodArgs = {new Object[]{3.5f, 0.5f}, new Object[]{3.5f, 0}};


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
