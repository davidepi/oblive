package it.oblive.correctness;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

/**
 * Test a static method of a class, all the other will be normal methods
 */
public class TestRecursiveMethod extends AbstractTestCorrectnessTemplate {
    private Class<?> className = testclasses.RecursiveMethod.class;
    private String[] methodTest = {"factorial"};
    private Class[][] methodParam = {new Class[]{int.class}};
    private Object[][] methodArgs = {new Object[]{15}};

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
