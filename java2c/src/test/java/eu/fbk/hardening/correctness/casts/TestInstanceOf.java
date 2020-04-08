package eu.fbk.hardening.correctness.casts;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

import java.io.File;

public class TestInstanceOf extends AbstractTestCorrectnessTemplate {
    private Class<?> className = testclasses.casts.InstanceOf.class;
    private String[] methodTest = {"instanceofString", "instanceofString", "instanceofString"};
    private Class[][] methodParam = {new Class[]{Object.class}, new Class[]{Object.class}, new Class[]{Object.class}};
    private Object[][] methodArgs = {new Object[]{"hello"}, new Object[]{new File("aaa")}, new Object[]{null}};

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
