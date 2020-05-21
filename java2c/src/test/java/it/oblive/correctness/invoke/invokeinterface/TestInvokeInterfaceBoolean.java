package it.oblive.correctness.invoke.invokeinterface;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;
import testclasses.invoke.invokeinterface.AdderInterface;
import testclasses.invoke.invokeinterface.ImplementedInterface;

public class TestInvokeInterfaceBoolean extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.invoke.invokeinterface.InvokeInterfaceBoolean.class;
    private String[] methodTest = {"and", "and", "and", "and"};
    private Class[][] methodParam = {new Class[]{AdderInterface.class, boolean.class, boolean.class},
            new Class[]{AdderInterface.class, boolean.class, boolean.class},
            new Class[]{AdderInterface.class, boolean.class, boolean.class},
            new Class[]{AdderInterface.class, boolean.class, boolean.class}};
    private Object[][] methodArgs = {new Object[]{new ImplementedInterface(), false, false},
            new Object[]{new ImplementedInterface(), true, false},
            new Object[]{new ImplementedInterface(), false, true},
            new Object[]{new ImplementedInterface(), true, true}};

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
