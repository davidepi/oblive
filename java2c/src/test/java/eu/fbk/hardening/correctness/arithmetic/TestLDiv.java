package eu.fbk.hardening.correctness.arithmetic;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestLDiv extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.arithmetic.LDiv.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{long.class, long.class}};
    private Object[][] methodArgs = {new Object[]{15000000000L, 21000000000L}};


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
