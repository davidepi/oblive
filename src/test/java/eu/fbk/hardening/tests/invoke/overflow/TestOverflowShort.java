package eu.fbk.hardening.tests.invoke.overflow;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestOverflowShort extends AbstractTestCorrectnessTemplate
{

    private Class<?> className = testclasses.invoke.overflow.OverflowShort.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{short.class, short.class}};
    private Object[][] methodArgs = {new Object[]{Short.MAX_VALUE, (short) 1000}};


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
