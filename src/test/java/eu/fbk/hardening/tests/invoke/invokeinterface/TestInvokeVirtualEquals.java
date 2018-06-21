package eu.fbk.hardening.tests.invoke.invokeinterface;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;
import testclasses.invoke.invokeinterface.InvokeInterfaceEquals;

public class TestInvokeVirtualEquals extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.invoke.invokeinterface.InvokeInterfaceEquals.class;
    private String[] methodTest = {"equals"};
    private Class[][] methodParam = {new Class[]{Object.class}};
    private Object[][] methodArgs = {new Object[]{new InvokeInterfaceEquals()}};


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
