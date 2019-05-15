package eu.fbk.hardening.tests.invoke.invokestatic;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestInvokeStaticDouble extends AbstractTestCorrectnessTemplate
{

    private Class<?> className = testclasses.invoke.invokestatic.InvokeStaticDouble.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{double.class, double.class}};
    private Object[][] methodArgs = {new Object[]{3.14159265359, 2.7182818284}};


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
