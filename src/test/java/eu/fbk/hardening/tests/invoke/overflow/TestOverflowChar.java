package eu.fbk.hardening.tests.invoke.overflow;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestOverflowChar extends AbstractTestCorrectnessTemplate
{

    private Class<?> className = testclasses.invoke.overflow.OverflowChar.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{char.class, char.class}};
    private Object[][] methodArgs = {new Object[]{Character.MAX_VALUE, (char)0x1}};


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
