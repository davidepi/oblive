package it.oblive.correctness;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

/**
 * Tests for multiple methods in the same class
 */
public class TestMultipleMethods extends AbstractTestCorrectnessTemplate {
    private Class<?> className = testclasses.MultiMethods.class;
    private String[] methodTest = {"add", "sub", "mul", "div"};
    private Class[][] methodParam = {new Class[]{int.class, int.class}, new Class[]{int.class, int.class},
            new Class[]{int.class, int.class}, new Class[]{int.class, int.class}};
    private Object[][] methodArgs = {new Object[]{15, 21}, new Object[]{15, 21},
            new Object[]{15, 21}, new Object[]{15, 21}};

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
