package it.oblive.correctness.mangling;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;
import testclasses.mangling.Underscore_Class;

/**
 * Tests for multiple methods in the same class
 */
public class TestUnderscore_Class extends AbstractTestCorrectnessTemplate {
    private Class<?> className = Underscore_Class.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{int.class, int.class}};
    private Object[][] methodArgs = {new Object[]{15, 21}};

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
