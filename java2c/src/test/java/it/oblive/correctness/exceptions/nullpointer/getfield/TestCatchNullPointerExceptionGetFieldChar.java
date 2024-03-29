package it.oblive.correctness.exceptions.nullpointer.getfield;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;
import testclasses.exceptions.nullpointer.getfield.CatchNullPointerExceptionGetFieldChar;

public class TestCatchNullPointerExceptionGetFieldChar extends AbstractTestCorrectnessTemplate {
    private Class<?> className = CatchNullPointerExceptionGetFieldChar.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{testclasses.exceptions.nullpointer.SupportClassChar.class}};
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
