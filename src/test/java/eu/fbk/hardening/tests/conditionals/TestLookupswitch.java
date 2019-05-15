package eu.fbk.hardening.tests.conditionals;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestLookupswitch extends AbstractTestCorrectnessTemplate
{
    private Class<?> className = testclasses.conditionals.Lookupswitch.class;
    private String[] methodTest = {"exec", "exec", "exec"};
    private Class[][] methodParam = {new Class[]{int.class}, new Class[]{int.class}, new Class[]{int.class}};
    private Object[][] methodArgs = {new Object[]{1000000}, new Object[]{-5000}, new Object[]{0}};

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
