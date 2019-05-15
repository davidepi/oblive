package eu.fbk.hardening.tests.exceptions.negativesize.multidimensional;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;
import testclasses.exceptions.negativesize.multidimensional.CatchNegativeArraySizeDouble;

public class TestCatchNegativeArraySizeFloat extends AbstractTestCorrectnessTemplate
{
    private Class<?> className = CatchNegativeArraySizeDouble.class;
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
