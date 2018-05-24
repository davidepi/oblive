package eu.fbk.hardening.tests.invoke.overflow;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;

public class TestOverflowByte extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.invoke.overflow.OverflowByte.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{byte.class, byte.class}};
    private Object[][] methodArgs = {new Object[]{Byte.MAX_VALUE, (byte)1}};


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
