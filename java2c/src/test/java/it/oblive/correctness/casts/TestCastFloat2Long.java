package it.oblive.correctness.casts;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

public class TestCastFloat2Long extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.casts.CastFloat2Long.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{float.class}};
    private Object[][] methodArgs = {new Object[]{3.25f}};


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
