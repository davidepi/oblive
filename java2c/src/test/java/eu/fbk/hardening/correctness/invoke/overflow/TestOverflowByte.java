package eu.fbk.hardening.correctness.invoke.overflow;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestOverflowByte extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.invoke.overflow.OverflowByte.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{byte.class, byte.class}};
    private Object[][] methodArgs = {new Object[]{Byte.MAX_VALUE, (byte) 1}};


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
