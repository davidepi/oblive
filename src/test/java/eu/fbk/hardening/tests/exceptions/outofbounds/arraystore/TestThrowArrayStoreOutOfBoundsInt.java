package eu.fbk.hardening.tests.exceptions.outofbounds.arraystore;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestThrowArrayStoreOutOfBoundsInt extends AbstractTestCorrectnessTemplate
{
    private Class<?> className = testclasses.exceptions.outofbounds.arraystore.ThrowArrayStoreOutOfBoundsInt.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{}};
    private Object[][] methodArgs = {new Object[]{}};

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
