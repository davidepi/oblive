package it.oblive.correctness.arithmetic;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

public class TestIOr extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.arithmetic.IOr.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{int.class, int.class}};
    private Object[][] methodArgs = {new Object[]{11234567, 2478945}};

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
