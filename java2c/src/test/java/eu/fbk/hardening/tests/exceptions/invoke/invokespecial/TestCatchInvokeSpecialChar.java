package eu.fbk.hardening.tests.exceptions.invoke.invokespecial;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;
import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;

public class TestCatchInvokeSpecialChar extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.exceptions.invoke.invokespecial.CatchInvokeSpecialChar.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{char.class,char.class}};
    private Object[][] methodArgs = {new Object[]{'A','b'}};

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
