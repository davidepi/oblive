package it.oblive.correctness.arrays.multidimensional;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

public class TestLengthArrayLong extends AbstractTestCorrectnessTemplate {
    private Class<?> className = testclasses.arrays.multidimensional.LengthArrayLong.class;
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
