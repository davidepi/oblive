package it.oblive.correctness.arithmetic;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

public class TestLUShr extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.arithmetic.LUShr.class;
    private String[] methodTest = {"exec", "exec"};
    private Class[][] methodParam = {new Class[]{long.class, int.class}, new Class[]{long.class, int.class}};
    private Object[][] methodArgs = {new Object[]{1L, 33}, new Object[]{-1L, 33}};

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
