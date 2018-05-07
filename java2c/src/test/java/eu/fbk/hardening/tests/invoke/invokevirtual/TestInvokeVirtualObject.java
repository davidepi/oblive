package eu.fbk.hardening.tests.invoke.invokevirtual;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;

public class TestInvokeVirtualObject extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.invoke.invokevirtual.InvokeVirtualObject.class;
    private String[] methodTest = {"concatenate"};
    private Class[][] methodParam = {new Class[]{java.lang.String.class,char.class}};
    private Object[][] methodArgs = {new Object[]{"hello world",'!'}};


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
