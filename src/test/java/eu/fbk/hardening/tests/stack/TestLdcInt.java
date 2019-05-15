package eu.fbk.hardening.tests.stack;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestLdcInt extends AbstractTestCorrectnessTemplate
{

    private Class<?> className = testclasses.stack.LdcInt.class;
    private String[] methodTest = {"exec"};
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
