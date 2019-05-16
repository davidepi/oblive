package eu.fbk.hardening.correctness.casts;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestCastLong2Float extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.casts.CastLong2Float.class;
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
