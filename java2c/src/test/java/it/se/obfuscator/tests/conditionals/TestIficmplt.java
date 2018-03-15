package it.se.obfuscator.tests.conditionals;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;

public class TestIficmplt extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.conditionals.Ificmplt.class;
    private String[] methodTest = {"exec","exec","exec"};
    private Class[][] methodParam = {new Class[]{int.class},new Class[]{int.class},new Class[]{int.class}};
    private Object[][] methodArgs = {new Object[]{1000000000}, new Object[]{0},new Object[]{2000000000}};

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
