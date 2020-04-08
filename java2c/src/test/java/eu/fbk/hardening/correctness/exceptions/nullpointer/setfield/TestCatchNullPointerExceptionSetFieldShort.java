package eu.fbk.hardening.correctness.exceptions.nullpointer.setfield;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;
import testclasses.exceptions.nullpointer.setfield.CatchNullPointerExceptionSetFieldShort;

public class TestCatchNullPointerExceptionSetFieldShort extends AbstractTestCorrectnessTemplate {
    private Class<?> className = CatchNullPointerExceptionSetFieldShort.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{testclasses.exceptions.nullpointer.SupportClassShort.class}};
    private Object[][] methodArgs = {new Object[]{null}};

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
