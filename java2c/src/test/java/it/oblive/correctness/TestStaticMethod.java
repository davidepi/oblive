package it.oblive.correctness;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

/**
 * Test a static method of a class, all the other will be normal methods
 */
public class TestStaticMethod extends AbstractTestCorrectnessTemplate {
    private Class<?> className = testclasses.AdderStaticMethod.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{int.class, int.class}};
    private Object[][] methodArgs = {new Object[]{15, 21}};

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
