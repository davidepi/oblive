package eu.fbk.hardening.tests.arithmetic;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;

public class TestIUShr extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.arithmetic.IUShr.class;
    private String[] methodTest = {"exec", "exec"};
    private Class[][] methodParam = {new Class[]{int.class, int.class}, new Class[]{int.class, int.class}};
    private Object[][] methodArgs = {new Object[]{1, 3}, new Object[]{-1, 3}};

    @Override
    public String getAnnotatedMethodName(int position)
    {
        return this.getTestMethodName(0);
    }

    @Override
    public int getAnnotatedMethodSize()
    {
        return 1;
    }

    @Override
    public Class<?>[] getAnnotatedMethodParams(int position)
    {
        return this.getTestMethodParams(0);
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
