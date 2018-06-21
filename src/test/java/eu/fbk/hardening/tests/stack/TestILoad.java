package eu.fbk.hardening.tests.stack;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;

public class TestILoad extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.stack.ILoad.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{int.class}};
    private Object[][] methodArgs = {new Object[]{1000000000}};


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
