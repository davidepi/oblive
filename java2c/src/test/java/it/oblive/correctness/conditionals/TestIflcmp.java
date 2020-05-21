package it.oblive.correctness.conditionals;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

public class TestIflcmp extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.conditionals.Iflcmp.class;
    private String[] methodTest = {"exec", "exec", "exec"};
    private Class[][] methodParam = {new Class[]{long.class}, new Class[]{long.class}, new Class[]{long.class}};
    private Object[][] methodArgs = {new Object[]{1000000000L}, new Object[]{10000000000L}, new Object[]{20000000000L}};


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
