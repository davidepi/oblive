package eu.fbk.hardening.tests.exceptions.invoke.invokespecial;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestThrowInvokeSpecialChar extends AbstractTestCorrectnessTemplate
{

    private Class<?> className = testclasses.exceptions.invoke.invokespecial.ThrowInvokeSpecialChar.class;
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
