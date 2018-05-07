package eu.fbk.hardening.tests.invoke.invokevirtual;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;

public class TestInvokeVirtualNoInput extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.invoke.invokevirtual.InvokeVirtualNoInput.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{int.class,int.class}};
    private Object[][] methodArgs = {new Object[]{15,18}};


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
