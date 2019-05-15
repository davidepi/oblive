package eu.fbk.hardening.tests.overload;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestOverloadedMethodsBoolean extends AbstractTestCorrectnessTemplate
{
    private Class<?> className = testclasses.overload.OverloadedMethodsBoolean.class;
    private String[] methodTest = {"add", "add"};
    private Class[][] methodParam = {new Class[]{int.class, double.class}, new Class[]{boolean.class, boolean.class}};
    private Object[][] methodArgs = {new Object[]{15, 21}, new Object[]{true, true}};

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
