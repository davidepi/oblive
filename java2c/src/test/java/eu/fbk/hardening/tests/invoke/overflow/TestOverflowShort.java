package eu.fbk.hardening.tests.invoke.overflow;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;

public class TestOverflowShort extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.invoke.overflow.OverflowShort.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{short.class, short.class}};
    private Object[][] methodArgs = {new Object[]{Short.MAX_VALUE, (short) 1000}};


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
