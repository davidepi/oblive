package it.oblive.correctness.conditionals;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

public class TestLookupswitchString extends AbstractTestCorrectnessTemplate {
    private Class<?> className = testclasses.conditionals.LookupswitchString.class;
    private String[] methodTest = {"exec", "exec", "exec"};
    private Class[][] methodParam = {new Class[]{String.class}, new Class[]{String.class}, new Class[]{String.class}};
    private Object[][] methodArgs = {new Object[]{"hello"}, new Object[]{"世界"}, new Object[]{"no"}};


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
