package eu.fbk.hardening.correctness.fields;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestSetStaticChar extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.fields.SetStaticChar.class;
    private String[] methodTest = {"getStatic"};
    private Class[][] methodParam = {new Class[]{}};
    private Object[][] methodArgs = {new Object[]{}};
    private String[] annotatedMethod = {"setStatic"};
    private Class[][] annotatedParams = {new Class[]{char.class}};


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

    @Override
    public String[] getAnnotatedMethodName() {
        return annotatedMethod;
    }

    @Override
    public Class<?>[][] getAnnotatedMethodParams() {
        return this.annotatedParams;
    }
}
