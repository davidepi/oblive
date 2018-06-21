package eu.fbk.hardening.tests.casts;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;

public class TestCheckCast extends AbstractTestMethodTemplate
{
    private Class<?> className = testclasses.casts.CheckCast.class;
    private String[] methodTest = {"castString", "castString"};
    private Class[][] methodParam = {new Class[]{Object.class}, new Class[]{Object.class}};
    private Object[][] methodArgs = {new Object[]{"hello"}, new Object[]{null}};

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
