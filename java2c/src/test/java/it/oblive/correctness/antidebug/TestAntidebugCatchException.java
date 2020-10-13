package it.oblive.correctness.antidebug;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;
import testclasses.antidebug.AntidebugCatchException;

public class TestAntidebugCatchException extends AbstractTestCorrectnessTemplate {
    private Class<?> className = AntidebugCatchException.class;
    private String[] methodTest = {"convert"};
    private Class[][] methodParam = {new Class[]{String.class}};
    private Object[][] methodArgs = {new Object[]{"xyz"}};

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
