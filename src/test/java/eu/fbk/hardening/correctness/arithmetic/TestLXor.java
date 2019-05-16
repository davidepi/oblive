package eu.fbk.hardening.correctness.arithmetic;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestLXor extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.arithmetic.LXor.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{long.class, long.class}};
    private Object[][] methodArgs = {new Object[]{11234567649753L, 2478945674951L}};

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
