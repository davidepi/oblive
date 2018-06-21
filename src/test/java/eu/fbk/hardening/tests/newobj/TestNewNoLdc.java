package eu.fbk.hardening.tests.newobj;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;

public class TestNewNoLdc extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.newobj.NewObjectNoLdc.class;
    private String[] methodTest = {"getObject"};
    private Class[][] methodParam = {new Class[]{int.class, long.class, double.class, java.lang.String.class}};
    private Object[][] methodArgs = {new Object[]{1000000, 10000000000L, 3.5, "hello"}};

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
