package eu.fbk.hardening.correctness.exceptions.nullpointer.arrayload;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;
import testclasses.exceptions.nullpointer.SupportClassFloat;

public class TestCatchNullPointerExceptionXLOADFloat extends AbstractTestCorrectnessTemplate {
    private Class<?> className = testclasses.exceptions.nullpointer.arrayload.CatchNullPointerExceptionXLOADFloat.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{SupportClassFloat.class}};
    private Object[][] methodArgs = {new Object[]{new SupportClassFloat()}};

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
