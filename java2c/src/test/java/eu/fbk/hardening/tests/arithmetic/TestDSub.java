package eu.fbk.hardening.tests.arithmetic;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;
import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;

public class TestDSub extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.arithmetic.DSub.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{double.class,double.class}};
    private Object[][] methodArgs = {new Object[]{3.5,2.5}};


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
