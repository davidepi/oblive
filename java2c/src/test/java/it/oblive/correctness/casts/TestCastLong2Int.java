package it.oblive.correctness.casts;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

public class TestCastLong2Int extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.casts.CastLong2Int.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{long.class}};
    private Object[][] methodArgs = {new Object[]{10000000000L}};


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
