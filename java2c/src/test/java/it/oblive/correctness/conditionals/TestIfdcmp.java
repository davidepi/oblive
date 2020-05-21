package it.oblive.correctness.conditionals;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

public class TestIfdcmp extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.conditionals.Ifdcmp.class;
    private String[] methodTest = {"exec", "exec", "exec"};
    private Class[][] methodParam = {new Class[]{double.class}, new Class[]{double.class}, new Class[]{double.class}};
    private Object[][] methodArgs = {new Object[]{2.5}, new Object[]{3.5}, new Object[]{4.5}};


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
