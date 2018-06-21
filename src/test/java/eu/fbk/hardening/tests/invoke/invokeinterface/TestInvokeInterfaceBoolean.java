package eu.fbk.hardening.tests.invoke.invokeinterface;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;
import testclasses.invoke.invokeinterface.AdderInterface;
import testclasses.invoke.invokeinterface.ImplementedInterface;

public class TestInvokeInterfaceBoolean extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.invoke.invokeinterface.InvokeInterfaceBoolean.class;
    private String[] methodTest = {"and", "and", "and", "and"};
    private Class[][] methodParam = {new Class[]{AdderInterface.class, boolean.class, boolean.class},
            new Class[]{AdderInterface.class, boolean.class, boolean.class},
            new Class[]{AdderInterface.class, boolean.class, boolean.class},
            new Class[]{AdderInterface.class, boolean.class, boolean.class}};
    private Object[][] methodArgs = {new Object[]{new ImplementedInterface(), false, false},
            new Object[]{new ImplementedInterface(), true, false},
            new Object[]{new ImplementedInterface(), false, true},
            new Object[]{new ImplementedInterface(), true, true}};

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
