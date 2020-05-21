package it.oblive.correctness.conditionals;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

public class TestIfnull extends AbstractTestCorrectnessTemplate {
    private Class<?> className = testclasses.conditionals.Ifnull.class;
    private String[] methodTest = {"exec", "exec"};
    private Class[][] methodParam = {new Class[]{Object.class}, new Class[]{Object.class}};
    private Object[][] methodArgs = {new Object[]{null}, new Object[]{"hello"}};


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
