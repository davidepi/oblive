package eu.fbk.hardening.tests.invoke.invokevirtual;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;

public class TestInvokeVirtualCastBoolean extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.invoke.invokevirtual.InvokeVirtualCastBoolean.class;
    private String[] methodTest = {"and", "and", "and", "and"};
    private Class[][] methodParam = {new Class[]{boolean.class, boolean.class}, new Class[]{boolean.class, boolean.class},
            new Class[]{boolean.class, boolean.class}, new Class[]{boolean.class, boolean.class}};
    private Object[][] methodArgs = {new Object[]{false, false}, new Object[]{true, false},
            new Object[]{false, true}, new Object[]{true, true}};


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
