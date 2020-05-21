package it.oblive.correctness.casts;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

public class TestCheckCastJavaType extends AbstractTestCorrectnessTemplate {
    private Class<?> className = testclasses.casts.CheckCastJavaType.class;
    private String[] methodTest = {"castString", "castString"};
    private Class[][] methodParam = {new Class[]{Object.class}, new Class[]{Object.class}};
    private Object[][] methodArgs = {new Object[]{"hello"}, new Object[]{null}};

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
