package eu.fbk.hardening.tests;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;

public class TestMultipleMethods extends AbstractTestMethodTemplate
{
    private Class<?> className = testclasses.MultiMethods.class;
    private String[] methodTest = {"add", "sub", "mul", "div"};
    private Class[][] methodParam = {new Class[]{int.class, int.class}, new Class[]{int.class, int.class},
            new Class[]{int.class, int.class}, new Class[]{int.class, int.class}};
    private Object[][] methodArgs = {new Object[]{15, 21}, new Object[]{15, 21},
            new Object[]{15, 21}, new Object[]{15, 21}};

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
