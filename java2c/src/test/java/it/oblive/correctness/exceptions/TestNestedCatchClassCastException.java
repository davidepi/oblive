package it.oblive.correctness.exceptions;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

import java.io.File;

public class TestNestedCatchClassCastException extends AbstractTestCorrectnessTemplate {
    private Class<?> className = testclasses.exceptions.NestedCatchClassCastException.class;
    private String[] methodTest = {"castString", "castString"};
    private Class[][] methodParam = {new Class[]{Object.class}, new Class[]{Object.class}};
    private Object[][] methodArgs = {new Object[]{new File("aaa")}, new Object[]{"aaa"}};

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
