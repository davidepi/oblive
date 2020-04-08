package eu.fbk.hardening.correctness.invoke.invokevirtual;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestInvokeVirtualCastShort extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.invoke.invokevirtual.InvokeVirtualCastShort.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{short.class, short.class}};
    private Object[][] methodArgs = {new Object[]{(short) 15000, (short) 1000}};


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
