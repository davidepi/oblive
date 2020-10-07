package it.oblive.correctness.antidebug;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

/**
 * Test a static method of a class, all the other will be normal methods
 */
public class TestAntidebugSelfDebuggingMulticall extends AbstractTestCorrectnessTemplate {
    private Class<?> className = testclasses.antidebug.AntidebugSelfDebuggingMulticall.class;
    private String[] methodTest = {"doubleAdd"};
    private Class[][] methodParam = {new Class[]{int.class, int.class}};
    private Object[][] methodArgs = {new Object[]{256, 1}};

    @Override
    public String[] getAnnotatedMethodName() {
        return new String[]{"nativeAdd"};
    }

    @Override
    public Class<?>[][] getAnnotatedMethodParams() {
        return new Class[][]{new Class[]{int.class, int.class}};
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
