package eu.fbk.hardening.tests.invoke.invokevirtual;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestInvokeVirtualCastChar extends AbstractTestCorrectnessTemplate
{

    private Class<?> className = testclasses.invoke.invokevirtual.InvokeVirtualCastChar.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{char.class, char.class}};
    private Object[][] methodArgs = {new Object[]{'A', 'b'}};


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
