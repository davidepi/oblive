package it.oblive.correctness.stack;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

public class TestDLoad extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.stack.DLoad.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{double.class}};
    private Object[][] methodArgs = {new Object[]{4.5f}};


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
