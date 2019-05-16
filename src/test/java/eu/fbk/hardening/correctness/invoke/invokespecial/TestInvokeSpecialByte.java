package eu.fbk.hardening.correctness.invoke.invokespecial;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testclasses.invoke.invokespecial.InvokeSpecialByte;
import testclasses.invoke.invokevirtual.InvokeVirtualByte;

public class TestInvokeSpecialByte extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.invoke.invokespecial.InvokeSpecialByte.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{byte.class, byte.class}};
    private Object[][] methodArgs = {new Object[]{(byte) 15, (byte) 18}};

    @Test
    public void testSuperMethodIsCalled() {
        InvokeSpecialByte testme = new InvokeSpecialByte();
        InvokeVirtualByte check = new InvokeVirtualByte();
        //the normalAdd method of the testme class is wrong on purpose, the class should call the superclass one
        Assertions.assertEquals(check.normalAdd((byte) 15, (byte) 18), testme.add((byte) 15, (byte) 18));
        Assertions.assertNotEquals(check.normalAdd((byte) 15, (byte) 18), testme.normalAdd((byte) 15, (byte) 18));
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
