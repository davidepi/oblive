package eu.fbk.hardening.tests.arrays.unidimensional;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestLengthArrayDouble extends AbstractTestCorrectnessTemplate
{
    private Class<?> className = testclasses.arrays.unidimensional.LengthArrayDouble.class;
    private String[] methodTest = {"getLen"};
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
