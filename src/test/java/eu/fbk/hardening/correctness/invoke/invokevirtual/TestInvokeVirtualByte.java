package eu.fbk.hardening.correctness.invoke.invokevirtual;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestInvokeVirtualByte extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.invoke.invokevirtual.InvokeVirtualByte.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{byte.class, byte.class}};
    private Object[][] methodArgs = {new Object[]{(byte) 15, (byte) 18}};


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
