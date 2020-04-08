package eu.fbk.hardening.correctness.exceptions.invoke.invokevirtual;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestCatchInvokeVirtualLong extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.exceptions.invoke.invokevirtual.CatchInvokeVirtualLong.class;
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
