package eu.fbk.hardening.tests.arithmetic;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;
import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;

public class TestLOr extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.arithmetic.LOr.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{long.class,long.class}};
    private Object[][] methodArgs = {new Object[]{11234567649753L,2478945674951L}};

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
