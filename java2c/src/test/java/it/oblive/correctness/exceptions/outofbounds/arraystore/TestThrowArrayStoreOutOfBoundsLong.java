package it.oblive.correctness.exceptions.outofbounds.arraystore;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

public class TestThrowArrayStoreOutOfBoundsLong extends AbstractTestCorrectnessTemplate {
    private Class<?> className = testclasses.exceptions.outofbounds.arraystore.ThrowArrayStoreOutOfBoundsLong.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{}};
    private Object[][] methodArgs = {new Object[]{}};

    @Override
    public Class<?> getTestClass() {
        return className;
    }

    @Override
    public String[] getTestMethodName() {
        return methodTest;
    }

    @Override
    public Class<?>[][] getTestMethodParams() {
        return methodParam;
    }

    @Override
    public Object[][] getTestMethodArgs() {
        return methodArgs;
    }
}
