package eu.fbk.hardening.correctness.exceptions.invoke.invokestatic;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestCatchInvokeStaticLong extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.exceptions.invoke.invokestatic.CatchInvokeStaticLong.class;
    private String[] methodTest = {"div"};
    private Class[][] methodParam = {new Class[]{int.class}};
    private Object[][] methodArgs = {new Object[]{10}};


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
