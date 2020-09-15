package it.oblive.correctness.antidebug;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

public class TestAntidebugSelfDebuggingRecursive extends AbstractTestCorrectnessTemplate {
    private Class<?> className = testclasses.antidebug.AntidebugSelfDebuggingRecursive.class;
    private String[] methodTest = {"factorial"};
    private Class[][] methodParam = {new Class[]{int.class}};
    private Object[][] methodArgs = {new Object[]{8}};

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