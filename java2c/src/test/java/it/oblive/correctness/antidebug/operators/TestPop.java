package it.oblive.correctness.antidebug.operators;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

public class TestPop extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.antidebug.operators.Pop.class;
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
