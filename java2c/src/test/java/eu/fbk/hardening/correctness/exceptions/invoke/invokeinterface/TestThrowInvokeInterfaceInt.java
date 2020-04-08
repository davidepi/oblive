package eu.fbk.hardening.correctness.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;
import testclasses.exceptions.invoke.invokeinterface.DivisionInterface;
import testclasses.exceptions.invoke.invokeinterface.ImplementedInterface;

public class TestThrowInvokeInterfaceInt extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.exceptions.invoke.invokeinterface.ThrowInvokeInterfaceInt.class;
    private String[] methodTest = {"div"};
    private Class[][] methodParam = {new Class[]{DivisionInterface.class, int.class}};
    private Object[][] methodArgs = {new Object[]{new ImplementedInterface(), 10}};


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
