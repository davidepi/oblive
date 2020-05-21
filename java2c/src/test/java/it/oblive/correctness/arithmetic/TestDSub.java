package it.oblive.correctness.arithmetic;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

public class TestDSub extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.arithmetic.DSub.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{double.class, double.class}};
    private Object[][] methodArgs = {new Object[]{3.5, 2.5}};


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
