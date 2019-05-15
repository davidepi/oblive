package eu.fbk.hardening.tests.stack;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestALoad extends AbstractTestCorrectnessTemplate
{

    private Class<?> className = testclasses.stack.ALoad.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{java.lang.String.class}};
    private Object[][] methodArgs = {new Object[]{"hello"}};


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
