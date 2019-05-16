package eu.fbk.hardening.correctness.conditionals;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestIffcmp extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.conditionals.Iffcmp.class;
    private String[] methodTest = {"exec", "exec", "exec"};
    private Class[][] methodParam = {new Class[]{float.class}, new Class[]{float.class}, new Class[]{float.class}};
    private Object[][] methodArgs = {new Object[]{2.5f}, new Object[]{3.5f}, new Object[]{4.5f}};


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
