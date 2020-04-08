package eu.fbk.hardening.correctness.arithmetic;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestFNeg extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.arithmetic.FNeg.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{float.class}};
    private Object[][] methodArgs = {new Object[]{-3.5f}};


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
