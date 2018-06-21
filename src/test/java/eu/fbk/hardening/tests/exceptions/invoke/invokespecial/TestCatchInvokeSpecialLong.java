package eu.fbk.hardening.tests.exceptions.invoke.invokespecial;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;

public class TestCatchInvokeSpecialLong extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.exceptions.invoke.invokespecial.CatchInvokeSpecialLong.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{long.class, long.class}};
    private Object[][] methodArgs = {new Object[]{0x200000001L, 0x400000002L}};

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
