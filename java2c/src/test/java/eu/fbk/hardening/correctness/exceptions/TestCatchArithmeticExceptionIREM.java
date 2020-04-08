package eu.fbk.hardening.correctness.exceptions;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestCatchArithmeticExceptionIREM extends AbstractTestCorrectnessTemplate {
    private Class<?> className = testclasses.exceptions.CatchArithmeticExceptionIREM.class;
    private String[] methodTest = {"divide"};
    private Class[][] methodParam = {new Class[]{int.class}};
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
