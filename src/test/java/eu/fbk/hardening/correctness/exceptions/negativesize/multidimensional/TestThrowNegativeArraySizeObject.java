package eu.fbk.hardening.correctness.exceptions.negativesize.multidimensional;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;
import testclasses.exceptions.negativesize.multidimensional.ThrowNegativeArraySizeObject;

public class TestThrowNegativeArraySizeObject extends AbstractTestCorrectnessTemplate {
    private Class<?> className = ThrowNegativeArraySizeObject.class;
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