package eu.fbk.hardening.tests.exceptions;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

import java.io.File;

public class TestThrowClassCastException extends AbstractTestCorrectnessTemplate
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
    public String[] getTestMethodName()
    {
        return methodTest;
    }

    @Override
    public Class<?>[][] getTestMethodParams()
    {
        return methodParam;
    }

    @Override
    public Object[][] getTestMethodArgs()
    {
        return methodArgs;
    }
}
