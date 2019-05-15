package eu.fbk.hardening.tests.exceptions;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestThrowArithmeticExceptionLDIV extends AbstractTestCorrectnessTemplate
{
    private Class<?> className = testclasses.exceptions.ThrowArithmeticExceptionLDIV.class;
    private String[] methodTest = {"divide"};
    private Class[][] methodParam = {new Class[]{long.class}};
    private Object[][] methodArgs = {new Object[]{10}};

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
