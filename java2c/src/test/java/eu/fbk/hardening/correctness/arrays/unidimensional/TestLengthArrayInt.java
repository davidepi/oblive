package eu.fbk.hardening.correctness.arrays.unidimensional;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestLengthArrayInt extends AbstractTestCorrectnessTemplate {
    private Class<?> className = testclasses.arrays.unidimensional.LengthArrayInt.class;
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
