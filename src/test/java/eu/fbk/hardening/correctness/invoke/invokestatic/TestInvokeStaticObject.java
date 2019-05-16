package eu.fbk.hardening.correctness.invoke.invokestatic;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestInvokeStaticObject extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.invoke.invokestatic.InvokeStaticObject.class;
    private String[] methodTest = {"concatenate"};
    private Class[][] methodParam = {new Class[]{String.class, char.class}};
    private Object[][] methodArgs = {new Object[]{"hello world", '!'}};


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
