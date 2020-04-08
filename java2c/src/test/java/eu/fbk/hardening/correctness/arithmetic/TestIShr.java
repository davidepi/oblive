package eu.fbk.hardening.correctness.arithmetic;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestIShr extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.arithmetic.IShr.class;
    private String[] methodTest = {"exec", "exec"};
    private Class[][] methodParam = {new Class[]{int.class, int.class}, new Class[]{int.class, int.class}};
    private Object[][] methodArgs = {new Object[]{1, 3}, new Object[]{-1, 3}};

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
