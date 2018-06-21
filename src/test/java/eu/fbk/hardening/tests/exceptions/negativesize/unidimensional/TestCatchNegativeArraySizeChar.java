package eu.fbk.hardening.tests.exceptions.negativesize.unidimensional;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;
import testclasses.exceptions.negativesize.unidimensional.CatchNegativeArraySizeChar;

public class TestCatchNegativeArraySizeChar extends AbstractTestMethodTemplate
{
    private Class<?> className = CatchNegativeArraySizeChar.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{}};
    private Object[][] methodArgs = {new Object[]{}};

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
