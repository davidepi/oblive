package it.oblive.correctness.invoke.overflow;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

public class TestOverflowLong extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.invoke.overflow.OverflowLong.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{long.class, long.class}};
    private Object[][] methodArgs = {new Object[]{Long.MAX_VALUE, 1L}};


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
