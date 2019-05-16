package eu.fbk.hardening.correctness.exceptions;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestCatchArithmeticExceptionLREM extends AbstractTestCorrectnessTemplate {
    private Class<?> className = testclasses.exceptions.CatchArithmeticExceptionLREM.class;
    private String[] methodTest = {"divide"};
    private Class[][] methodParam = {new Class[]{long.class}};
    private Object[][] methodArgs = {new Object[]{10000000000L}};

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
