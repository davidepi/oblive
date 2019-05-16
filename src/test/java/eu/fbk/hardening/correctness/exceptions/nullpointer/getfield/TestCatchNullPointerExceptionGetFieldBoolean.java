package eu.fbk.hardening.correctness.exceptions.nullpointer.getfield;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestCatchNullPointerExceptionGetFieldBoolean extends AbstractTestCorrectnessTemplate {
    private Class<?> className = testclasses.exceptions.nullpointer.getfield.CatchNullPointerExceptionGetFieldBoolean.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{testclasses.exceptions.nullpointer.SupportClassBoolean.class}};
    private Object[][] methodArgs = {new Object[]{null}};

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
