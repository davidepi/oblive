package it.se.obfuscator.tests.conditionals;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;

public class TestIfdcmp extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.conditionals.Ifdcmp.class;
    private String[] methodTest = {"exec","exec","exec"};
    private Class[][] methodParam = {new Class[]{double.class},new Class[]{double.class},new Class[]{double.class}};
    private Object[][] methodArgs = {new Object[]{2.5}, new Object[]{3.5},new Object[]{4.5}};

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
