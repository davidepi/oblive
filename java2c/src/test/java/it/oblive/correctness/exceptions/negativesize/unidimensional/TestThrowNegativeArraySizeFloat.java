package it.oblive.correctness.exceptions.negativesize.unidimensional;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;
import testclasses.exceptions.negativesize.unidimensional.ThrowNegativeArraySizeFloat;

public class TestThrowNegativeArraySizeFloat extends AbstractTestCorrectnessTemplate {
    private Class<?> className = ThrowNegativeArraySizeFloat.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{}};
    private Object[][] methodArgs = {new Object[]{}};

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
