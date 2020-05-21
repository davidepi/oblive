package it.oblive.correctness.invoke.invokevirtual;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;

public class TestInvokeVirtualBoolean extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.invoke.invokevirtual.InvokeVirtualBoolean.class;
    private String[] methodTest = {"and", "and", "and", "and"};
    private Class[][] methodParam = {new Class[]{boolean.class, boolean.class}, new Class[]{boolean.class,
            boolean.class},
            new Class[]{boolean.class, boolean.class}, new Class[]{boolean.class, boolean.class}};
    private Object[][] methodArgs = {new Object[]{false, false}, new Object[]{true, false},
            new Object[]{false, true}, new Object[]{true, true}};


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
