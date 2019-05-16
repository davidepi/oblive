package eu.fbk.hardening.correctness.fields;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestGetStaticDouble extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.fields.GetStaticDouble.class;
    private String[] methodTest = {"getStatic"};
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
