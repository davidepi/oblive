package eu.fbk.hardening.tests.arrays.multidimensional;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestNewArrayCharThreeDims extends AbstractTestCorrectnessTemplate
{
    private Class<?> className = testclasses.arrays.multidimensional.NewArrayCharThreeDims.class;
    private String[] methodTest = {"test"};
    private Class[][] methodParam = {new Class[]{}};
    private Object[][] methodArgs = {new Object[]{}};

    @Override
    public String[] getAnnotatedMethodName()
    {
        return new String[]{"getArray"};
    }

    @Override
    public Class<?>[][] getAnnotatedMethodParams()
    {
        return new Class[][]{};
    }

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
