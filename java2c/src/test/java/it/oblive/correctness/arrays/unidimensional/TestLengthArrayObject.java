package it.oblive.correctness.arrays.unidimensional;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

public class TestLengthArrayObject extends AbstractTestCorrectnessTemplate {
    private Class<?> className = testclasses.arrays.unidimensional.LengthArrayObject.class;
    private String[] methodTest = {"getLen"};
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
