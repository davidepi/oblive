package eu.fbk.hardening.correctness.exceptions.nullpointer.arraylength;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;
import testclasses.exceptions.nullpointer.SupportClassDouble;

public class TestThrowNullPointerExceptionArrayLengthDouble extends AbstractTestCorrectnessTemplate {
    private Class<?> className =
            testclasses.exceptions.nullpointer.arraylength.ThrowNullPointerExceptionArrayLengthDouble.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{SupportClassDouble.class}};
    private Object[][] methodArgs = {new Object[]{new SupportClassDouble()}};

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