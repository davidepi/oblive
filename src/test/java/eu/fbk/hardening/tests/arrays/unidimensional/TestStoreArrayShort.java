package eu.fbk.hardening.tests.arrays.unidimensional;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestStoreArrayShort extends AbstractTestCorrectnessTemplate
{
    private Class<?> className = testclasses.arrays.unidimensional.StoreArrayShort.class;
    private String[] methodTest = {"test"};
    private Class[][] methodParam = {new Class[]{}};
    private Object[][] methodArgs = {new Object[]{}};

    @Override
    public String getAnnotatedMethodName(int position)
    {
        return "setVal";
    }

    @Override
    public int getAnnotatedMethodSize()
    {
        return 1;
    }

    @Override
    public Class<?>[] getAnnotatedMethodParams(int position)
    {
        return new Class[]{int.class, short.class};
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
