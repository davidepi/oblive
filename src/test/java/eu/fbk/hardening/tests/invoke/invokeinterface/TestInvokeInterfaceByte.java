package eu.fbk.hardening.tests.invoke.invokeinterface;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;
import testclasses.invoke.invokeinterface.AdderInterface;
import testclasses.invoke.invokeinterface.ImplementedInterface;

public class TestInvokeInterfaceByte extends AbstractTestCorrectnessTemplate
{

    private Class<?> className = testclasses.invoke.invokeinterface.InvokeInterfaceByte.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{AdderInterface.class, byte.class, byte.class}};
    private Object[][] methodArgs = {new Object[]{new ImplementedInterface(), (byte) 15, (byte) 18}};


    @Override
    public Class<?> getTestClass()
    {
        return className;
    }

    @Override
    public String[] getTestMethodName()
    {
        return methodTest;
    }

    @Override
    public Class<?>[][] getTestMethodParams()
    {
        return methodParam;
    }

    @Override
    public Object[][] getTestMethodArgs()
    {
        return methodArgs;
    }
}
