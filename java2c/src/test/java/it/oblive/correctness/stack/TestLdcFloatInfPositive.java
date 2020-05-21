package it.oblive.correctness.stack;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

public class TestLdcFloatInfPositive extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.stack.LdcFloatInfPositive.class;
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
