package eu.fbk.hardening.tests.invoke.overflow;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;

public class TestOverflowChar extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.invoke.overflow.OverflowChar.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{char.class, char.class}};
    private Object[][] methodArgs = {new Object[]{Character.MAX_VALUE, (char)0x1}};


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
