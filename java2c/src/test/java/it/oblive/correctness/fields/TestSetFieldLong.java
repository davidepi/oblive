package it.oblive.correctness.fields;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

public class TestSetFieldLong extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.fields.SetFieldLong.class;
    private String[] methodTest = {"getField"};
    private Class[][] methodParam = {new Class[]{}};
    private Object[][] methodArgs = {new Object[]{}};
    private String[] annotatedMethod = {"setField"};
    private Class[][] annotatedParams = {new Class[]{long.class}};


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

    @Override
    public String[] getAnnotatedMethodName() {
        return annotatedMethod;
    }

    @Override
    public Class<?>[][] getAnnotatedMethodParams() {
        return this.annotatedParams;
    }
}
