package it.oblive.correctness.mangling;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;
import testclasses.mangling.OverloadedMethodsFloat;

public class TestOverloadedMethodsFloat extends AbstractTestCorrectnessTemplate {
    private Class<?> className = OverloadedMethodsFloat.class;
    private String[] methodTest = {"add", "add"};
    private Class[][] methodParam = {new Class[]{int.class, int.class}, new Class[]{float.class, float.class}};
    private Object[][] methodArgs = {new Object[]{15, 21}, new Object[]{15, 18}};

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
