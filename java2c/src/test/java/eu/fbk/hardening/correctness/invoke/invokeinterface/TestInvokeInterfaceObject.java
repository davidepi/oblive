package eu.fbk.hardening.correctness.invoke.invokeinterface;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;
import testclasses.invoke.invokeinterface.AdderInterface;
import testclasses.invoke.invokeinterface.ImplementedInterface;

public class TestInvokeInterfaceObject extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.invoke.invokeinterface.InvokeInterfaceObject.class;
    private String[] methodTest = {"concatenate"};
    private Class[][] methodParam = {new Class[]{AdderInterface.class, String.class, char.class}};
    private Object[][] methodArgs = {new Object[]{new ImplementedInterface(), "hello world", '!'}};


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
