package eu.fbk.hardening.tests.fields;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestGetStaticBoolean extends AbstractTestCorrectnessTemplate
{

    private Class<?> className = testclasses.fields.GetStaticBoolean.class;
    private String[] methodTest = {"getStatic"};
    private Class[][] methodParam = {new Class[]{}};
    private Object[][] methodArgs = {new Object[]{}};


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
