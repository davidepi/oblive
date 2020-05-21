package it.oblive.correctness.exceptions.outofbounds.arrayload;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

public class TestCatchArrayLoadOutOfBoundsByte extends AbstractTestCorrectnessTemplate {
    private Class<?> className = testclasses.exceptions.outofbounds.arrayload.CatchArrayLoadOutOfBoundsByte.class;
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
