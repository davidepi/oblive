package it.oblive.correctness.fields;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

public class TestGetFieldBoolean extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.fields.GetFieldBoolean.class;
    private String[] methodTest = {"getField"};
    private Class[][] methodParam = {new Class[]{}};
    private Object[][] methodArgs = {new Object[]{}};


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
