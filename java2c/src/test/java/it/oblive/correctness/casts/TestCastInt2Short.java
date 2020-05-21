package it.oblive.correctness.casts;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

public class TestCastInt2Short extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.casts.CastInt2Short.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{int.class}};
    private Object[][] methodArgs = {new Object[]{1000000}};


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
