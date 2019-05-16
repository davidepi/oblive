package eu.fbk.hardening.correctness.arithmetic;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestFDiv extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.arithmetic.FDiv.class;
    private String[] methodTest = {"exec", "exec"};
    private Class[][] methodParam = {new Class[]{float.class, float.class}, new Class[]{float.class, float.class}};
    private Object[][] methodArgs = {new Object[]{3.5f, 0.5f}, new Object[]{3.5f, 0}};


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
