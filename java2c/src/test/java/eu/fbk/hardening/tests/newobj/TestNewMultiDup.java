package eu.fbk.hardening.tests.newobj;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;

public class TestNewMultiDup extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.newobj.NewObjectMultiDup.class;
    private String[] methodTest = {"getObject"};
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