package eu.fbk.hardening.tests.conditionals;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;
import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;

public class TestIffcmp extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.conditionals.Iffcmp.class;
    private String[] methodTest = {"exec","exec","exec"};
    private Class[][] methodParam = {new Class[]{float.class},new Class[]{float.class},new Class[]{float.class}};
    private Object[][] methodArgs = {new Object[]{2.5f}, new Object[]{3.5f},new Object[]{4.5f}};

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
