package eu.fbk.hardening.correctness.arrays.multidimensional;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestLoadArrayChar extends AbstractTestCorrectnessTemplate {
    private Class<?> className = testclasses.arrays.multidimensional.LoadArrayChar.class;
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