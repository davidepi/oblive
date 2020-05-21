package it.oblive.correctness.invoke.overflow;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

public class TestOverflowInt extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.invoke.overflow.OverflowInt.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{int.class, int.class}};
    private Object[][] methodArgs = {new Object[]{Integer.MAX_VALUE, 1}};


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
