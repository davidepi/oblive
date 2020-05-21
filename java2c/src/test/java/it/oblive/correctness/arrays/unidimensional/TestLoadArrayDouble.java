package it.oblive.correctness.arrays.unidimensional;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

public class TestLoadArrayDouble extends AbstractTestCorrectnessTemplate {
    private Class<?> className = testclasses.arrays.unidimensional.LoadArrayDouble.class;
    private String[] methodTest = {"getVal"};
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
