package eu.fbk.hardening.tests.exceptions.nullpointer.arraystore;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;
import testclasses.exceptions.nullpointer.SupportClassShort;

public class TestCatchNullPointerExceptionXSTOREShort extends AbstractTestMethodTemplate
{
    private Class<?> className = testclasses.exceptions.nullpointer.arraystore.CatchNullPointerExceptionXSTOREShort.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{SupportClassShort.class}};
    private Object[][] methodArgs = {new Object[]{new SupportClassShort()}};

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
