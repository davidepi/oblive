package it.se.obfuscator.tests.exceptions.negativesize.multidimensional;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;
import testclasses.exceptions.negativesize.multidimensional.ThrowNegativeArraySizeChar;

public class TestThrowNegativeArraySizeChar extends AbstractTestMethodTemplate
{
    private Class<?> className = ThrowNegativeArraySizeChar.class;
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
