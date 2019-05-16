package eu.fbk.hardening.correctness.conditionals;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestTableswitch extends AbstractTestCorrectnessTemplate {
    private Class<?> className = testclasses.conditionals.Tableswitch.class;
    private String[] methodTest = {"exec", "exec", "exec"};
    private Class[][] methodParam = {new Class[]{char.class}, new Class[]{char.class}, new Class[]{char.class}};
    private Object[][] methodArgs = {new Object[]{(char) 0}, new Object[]{(char) 2}, new Object[]{(char) -1}};


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
