package it.oblive.correctness.mangling;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;
import testclasses.mangling.UnderscoreMethod;
import testclasses.mangling.UnicodeMethod;

/**
 * Tests for multiple methods in the same class
 */
public class TestUnicodeMethod extends AbstractTestCorrectnessTemplate {
    private Class<?> className = UnicodeMethod.class;
    private String[] methodTest = {"天地玄黃宇宙洪荒"};
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
