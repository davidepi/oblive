package it.oblive.correctness.conditionals;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

public class TestGoto extends AbstractTestCorrectnessTemplate {
    private Class<?> className = testclasses.conditionals.Goto.class;
    private String[] methodTest = {"exec", "exec"};
    private Class[][] methodParam = {new Class[]{int.class}, new Class[]{int.class}};
    private Object[][] methodArgs = {new Object[]{10}, new Object[]{0}};

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
