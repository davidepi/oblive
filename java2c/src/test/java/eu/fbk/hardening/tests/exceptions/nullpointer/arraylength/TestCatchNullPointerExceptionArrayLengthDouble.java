package eu.fbk.hardening.tests.exceptions.nullpointer.arraylength;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;
import testclasses.exceptions.nullpointer.SupportClassDouble;

public class TestCatchNullPointerExceptionArrayLengthDouble extends AbstractTestMethodTemplate
{
    private Class<?> className = testclasses.exceptions.nullpointer.arraylength.CatchNullPointerExceptionArrayLengthDouble.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{SupportClassDouble.class}};
    private Object[][] methodArgs = {new Object[]{new SupportClassDouble()}};

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
