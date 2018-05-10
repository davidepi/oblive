package eu.fbk.hardening.tests.casts;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;

import java.io.File;

public class TestInstanceOf extends AbstractTestMethodTemplate
{
    private Class<?> className = testclasses.casts.InstanceOf.class;
    private String[] methodTest = {"instanceofString", "instanceofString", "instanceofString"};
    private Class[][] methodParam = {new Class[]{Object.class}, new Class[]{Object.class}, new Class[]{Object.class}};
    private Object[][] methodArgs = {new Object[]{"hello"}, new Object[]{new File("aaa")}, new Object[]{null}};

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
