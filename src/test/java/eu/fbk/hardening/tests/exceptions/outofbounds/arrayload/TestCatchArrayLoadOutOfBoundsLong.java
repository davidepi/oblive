package eu.fbk.hardening.tests.exceptions.outofbounds.arrayload;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestCatchArrayLoadOutOfBoundsLong extends AbstractTestCorrectnessTemplate
{
    private Class<?> className = testclasses.exceptions.outofbounds.arrayload.CatchArrayLoadOutOfBoundsLong.class;
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
