package eu.fbk.hardening.tests.arrays.unidimensional;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;

public class TestStoreArrayFloat extends AbstractTestMethodTemplate
{
    private Class<?> className = testclasses.arrays.unidimensional.StoreArrayFloat.class;
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
        return new Class[]{int.class,float.class};
    }

    @Override
    public Class<?> getTestClass()
    {
        return className;
    }

    @Override
    public String getTestMethodName(int position)
    {
        return methodTest[position];
    }

    @Override
    public int getTestMethodSize()
    {
        return methodTest.length;
    }

    @Override
    public Class<?>[] getTestMethodParams(int position)
    {
        return methodParam[position];
    }

    @Override
    public Object[] getTestMethodArgs(int position)
    {
        return methodArgs[position];
    }
}
