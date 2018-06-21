package eu.fbk.hardening.tests.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;
import testclasses.exceptions.invoke.invokeinterface.DivisionInterface;
import testclasses.exceptions.invoke.invokeinterface.ImplementedInterface;

public class TestCatchInvokeInterfaceBoolean extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.exceptions.invoke.invokeinterface.CatchInvokeInterfaceBoolean.class;
    private String[] methodTest = {"div"};
    private Class[][] methodParam = {new Class[]{DivisionInterface.class, boolean.class}};
    private Object[][] methodArgs = {new Object[]{new ImplementedInterface(), true}};


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
