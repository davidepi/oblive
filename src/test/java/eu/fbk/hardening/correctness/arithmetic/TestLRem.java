package eu.fbk.hardening.correctness.arithmetic;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestLRem extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.arithmetic.LNeg.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{long.class}};
    private Object[][] methodArgs = {new Object[]{-15000000000L}};


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
