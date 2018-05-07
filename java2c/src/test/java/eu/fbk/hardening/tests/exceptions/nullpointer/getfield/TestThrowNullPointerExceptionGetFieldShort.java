package eu.fbk.hardening.tests.exceptions.nullpointer.getfield;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;
import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;

public class TestThrowNullPointerExceptionGetFieldShort extends AbstractTestMethodTemplate
{
    private Class<?> className = testclasses.exceptions.nullpointer.getfield.ThrowNullPointerExceptionGetFieldShort.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{testclasses.exceptions.nullpointer.SupportClassShort.class}};
    private Object[][] methodArgs = {new Object[]{null}};

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
