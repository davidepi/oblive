package eu.fbk.hardening.correctness.newobj;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestNewMultiDup extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.newobj.NewObjectMultiDup.class;
    private String[] methodTest = {"getObject"};
    private Class[][] methodParam = {new Class[]{}};
    private Object[][] methodArgs = {new Object[]{}};

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
