package eu.fbk.hardening.correctness.invoke.invokevirtual;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestInvokeVirtualLong extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.invoke.invokevirtual.InvokeVirtualLong.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{long.class, long.class}};
    private Object[][] methodArgs = {new Object[]{0x200000001L, 0x400000002L}};


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
