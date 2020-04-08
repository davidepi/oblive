package eu.fbk.hardening.correctness.invoke.invokespecial;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testclasses.invoke.invokespecial.InvokeSpecialInt;
import testclasses.invoke.invokevirtual.InvokeVirtualInt;


public class TestInvokeSpecialInt extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.invoke.invokespecial.InvokeSpecialInt.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{int.class, int.class}};
    private Object[][] methodArgs = {new Object[]{1000000, -2000000}};

    @Test
    public void testSuperMethodIsCalled() {
        InvokeSpecialInt testme = new InvokeSpecialInt();
        InvokeVirtualInt check = new InvokeVirtualInt();
        //the normalAdd method of the testme class is wrong on purpose, the class should call the superclass one
        Assertions.assertEquals(check.normalAdd(15, 18), testme.add(15, 18));
        Assertions.assertNotEquals(check.normalAdd(15, 18), testme.normalAdd(15, 18));
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
