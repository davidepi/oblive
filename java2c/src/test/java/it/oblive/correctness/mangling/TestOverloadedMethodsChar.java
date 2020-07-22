package it.oblive.correctness.mangling;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;
import testclasses.mangling.OverloadedMethodsChar;

public class TestOverloadedMethodsChar extends AbstractTestCorrectnessTemplate {
    private Class<?> className = OverloadedMethodsChar.class;
    private String[] methodTest = {"add", "add"};
    private Class[][] methodParam = {new Class[]{int.class, double.class}, new Class[]{char.class, char.class}};
    private Object[][] methodArgs = {new Object[]{15, 21}, new Object[]{(char) 15, (char) 18}};

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
