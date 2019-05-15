package eu.fbk.hardening.tests.arithmetic;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestDDiv extends AbstractTestCorrectnessTemplate
{

    private Class<?> className = testclasses.arithmetic.DDiv.class;
    private String[] methodTest = {"exec", "exec"};
    private Class[][] methodParam = {new Class[]{double.class, double.class}, new Class[]{double.class, double.class}};
    private Object[][] methodArgs = {new Object[]{3.5, 2.5}, new Object[]{3.5, 0}};


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
