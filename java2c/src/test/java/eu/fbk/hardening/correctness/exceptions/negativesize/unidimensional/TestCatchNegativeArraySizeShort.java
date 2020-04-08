package eu.fbk.hardening.correctness.exceptions.negativesize.unidimensional;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;
import testclasses.exceptions.negativesize.unidimensional.CatchNegativeArraySizeShort;

public class TestCatchNegativeArraySizeShort extends AbstractTestCorrectnessTemplate {
    private Class<?> className = CatchNegativeArraySizeShort.class;
    private String[] methodTest = {"exec"};
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
