package eu.fbk.hardening.tests.exceptions;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;
import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;

import java.io.File;

public class TestThrowClassCastException extends AbstractTestMethodTemplate
{
    private Class<?> className = testclasses.exceptions.ThrowClassCastException.class;
    private String[] methodTest = {"castString"};
    private Class[][] methodParam = {new Class[]{Object.class}};
    private Object[][] methodArgs = {new Object[]{new File("aaa")}};

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
