package eu.fbk.hardening.correctness.invoke.invokestatic;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestInvokeStaticIntArray extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.invoke.invokestatic.InvokeStaticIntArray.class;
    private String[] methodTest = {"test"};
    private Class[][] methodParam = {new Class[]{}};
    private Object[][] methodArgs = {new Object[]{}};

    @Override
    public String[] getAnnotatedMethodName() {
        return new String[]{"exec"};
    }

    @Override
    public Class<?>[][] getAnnotatedMethodParams() {
        return new Class[][]{new Class[]{}};
    }

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
