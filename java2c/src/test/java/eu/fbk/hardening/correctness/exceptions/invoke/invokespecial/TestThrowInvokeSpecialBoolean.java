package eu.fbk.hardening.correctness.exceptions.invoke.invokespecial;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestThrowInvokeSpecialBoolean extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.exceptions.invoke.invokespecial.ThrowInvokeSpecialBoolean.class;
    private String[] methodTest = {"and"};
    private Class[][] methodParam = {new Class[]{boolean.class, boolean.class}};
    private Object[][] methodArgs = {new Object[]{false, false}};

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
