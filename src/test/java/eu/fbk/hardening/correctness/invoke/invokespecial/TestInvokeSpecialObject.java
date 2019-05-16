package eu.fbk.hardening.correctness.invoke.invokespecial;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testclasses.invoke.invokespecial.InvokeSpecialObject;
import testclasses.invoke.invokevirtual.InvokeVirtualObject;


public class TestInvokeSpecialObject extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.invoke.invokespecial.InvokeSpecialObject.class;
    private String[] methodTest = {"concatenate"};
    private Class[][] methodParam = {new Class[]{String.class, char.class}};
    private Object[][] methodArgs = {new Object[]{"hello world", '!'}};

    @Test
    public void testSuperMethodIsCalled() {
        InvokeSpecialObject testme = new InvokeSpecialObject();
        InvokeVirtualObject check = new InvokeVirtualObject();
        //the normalAdd method of the testme class is wrong on purpose, the class should call the superclass one
        Assertions.assertEquals(check.concatenate("hello", 'w'), testme.concatenate("hello", 'w'));
        Assertions.assertNotEquals(check.normalcat("hello", 'w'), testme.normalcat("hello", 'w'));
    }

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
