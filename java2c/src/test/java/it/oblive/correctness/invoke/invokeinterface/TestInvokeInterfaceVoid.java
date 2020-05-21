package it.oblive.correctness.invoke.invokeinterface;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;
import testclasses.invoke.invokeinterface.AdderInterface;
import testclasses.invoke.invokeinterface.ImplementedInterface;

public class TestInvokeInterfaceVoid extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.invoke.invokeinterface.InvokeInterfaceVoid.class;
    private String[] methodTest = {"print"};
    private Class[][] methodParam = {new Class[]{AdderInterface.class, int.class, int.class}};
    private Object[][] methodArgs = {new Object[]{new ImplementedInterface(), 15, 18}};


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
