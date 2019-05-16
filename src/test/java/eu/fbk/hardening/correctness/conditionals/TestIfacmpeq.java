package eu.fbk.hardening.correctness.conditionals;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestIfacmpeq extends AbstractTestCorrectnessTemplate {

    private String arg1 = "arg1";
    private String arg2 = "arg2";
    private Class<?> className = testclasses.conditionals.Ifacmpeq.class;
    private String[] methodTest = {"exec", "exec"};
    private Class[][] methodParam = {new Class[]{Object.class, Object.class}, new Class[]{Object.class, Object.class}};
    private Object[][] methodArgs = {new Object[]{arg1, arg2}, new Object[]{arg1, arg1}};


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
