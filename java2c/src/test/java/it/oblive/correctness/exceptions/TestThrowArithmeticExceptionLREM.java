package it.oblive.correctness.exceptions;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

public class TestThrowArithmeticExceptionLREM extends AbstractTestCorrectnessTemplate {
    private Class<?> className = testclasses.exceptions.ThrowArithmeticExceptionLREM.class;
    private String[] methodTest = {"mod"};
    private Class[][] methodParam = {new Class[]{long.class}};
    private Object[][] methodArgs = {new Object[]{10}};

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
