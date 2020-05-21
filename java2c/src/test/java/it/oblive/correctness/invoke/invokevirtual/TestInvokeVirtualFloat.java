package it.oblive.correctness.invoke.invokevirtual;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

public class TestInvokeVirtualFloat extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.invoke.invokevirtual.InvokeVirtualFloat.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{float.class, float.class}};
    private Object[][] methodArgs = {new Object[]{3.5f, -2.5f}};


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
