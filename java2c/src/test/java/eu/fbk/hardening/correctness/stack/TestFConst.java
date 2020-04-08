package eu.fbk.hardening.correctness.stack;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestFConst extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.stack.FConst.class;
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