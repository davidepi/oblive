package eu.fbk.hardening.correctness.arithmetic;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestIMul extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.arithmetic.IMul.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{int.class, int.class}};
    private Object[][] methodArgs = {new Object[]{15, 21}};


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
