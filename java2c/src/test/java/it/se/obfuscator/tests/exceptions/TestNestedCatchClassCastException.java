package it.se.obfuscator.tests.exceptions;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;

import java.io.File;

public class TestNestedCatchClassCastException extends AbstractTestMethodTemplate
{
    private Class<?> className = testclasses.exceptions.NestedCatchClassCastException.class;
    private String[] methodTest = {"castString","castString"};
    private Class[][] methodParam = {new Class[]{Object.class}, new Class[]{Object.class}};
    private Object[][] methodArgs = {new Object[]{new File("aaa")}, new Object[]{"aaa"}};

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
