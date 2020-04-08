package eu.fbk.hardening.correctness.arrays.multidimensional;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestStoreArrayInt extends AbstractTestCorrectnessTemplate {
    private Class<?> className = testclasses.arrays.multidimensional.StoreArrayInt.class;
    private String[] methodTest = {"test"};
    private Class[][] methodParam = {new Class[]{}};
    private Object[][] methodArgs = {new Object[]{}};

    @Override
    public String[] getAnnotatedMethodName() {
        return new String[]{"setVal"};
    }

    @Override
    public Class<?>[][] getAnnotatedMethodParams() {
        return new Class[][]{new Class[]{int.class, int.class, int.class}};
    }

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
