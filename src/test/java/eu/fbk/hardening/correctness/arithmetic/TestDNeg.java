package eu.fbk.hardening.correctness.arithmetic;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestDNeg extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.arithmetic.DNeg.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{double.class}};
    private Object[][] methodArgs = {new Object[]{3.5}};


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
