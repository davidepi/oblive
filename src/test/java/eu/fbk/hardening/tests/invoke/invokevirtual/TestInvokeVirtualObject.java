package eu.fbk.hardening.tests.invoke.invokevirtual;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestInvokeVirtualObject extends AbstractTestCorrectnessTemplate
{

    private Class<?> className = testclasses.invoke.invokevirtual.InvokeVirtualObject.class;
    private String[] methodTest = {"concatenate"};
    private Class[][] methodParam = {new Class[]{java.lang.String.class, char.class}};
    private Object[][] methodArgs = {new Object[]{"hello world", '!'}};


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
