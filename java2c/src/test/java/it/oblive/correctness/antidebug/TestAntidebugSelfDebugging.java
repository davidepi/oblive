package it.oblive.correctness.antidebug;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

/**
 * Test a static method of a class, all the other will be normal methods
 */
public class TestAntidebugSelfDebugging extends AbstractTestCorrectnessTemplate {
    private Class<?> className = testclasses.antidebug.AntidebugSelfDebugging.class;
    private String[] methodTest = {"pi"};
    private Class[][] methodParam = {new Class[]{int.class}};
    private Object[][] methodArgs = {new Object[]{1000}};

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
