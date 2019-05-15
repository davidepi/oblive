package eu.fbk.hardening.tests.exceptions.nullpointer.arrayload;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;
import testclasses.exceptions.nullpointer.SupportClassLong;

public class TestCatchNullPointerExceptionXLOADLong extends AbstractTestCorrectnessTemplate
{
    private Class<?> className = testclasses.exceptions.nullpointer.arrayload.CatchNullPointerExceptionXLOADLong.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{SupportClassLong.class}};
    private Object[][] methodArgs = {new Object[]{new SupportClassLong()}};

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
