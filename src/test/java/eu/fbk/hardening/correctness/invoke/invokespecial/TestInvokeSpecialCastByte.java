package eu.fbk.hardening.correctness.invoke.invokespecial;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testclasses.invoke.invokespecial.InvokeSpecialCastByte;
import testclasses.invoke.invokevirtual.InvokeVirtualCastByte;


public class TestInvokeSpecialCastByte extends AbstractTestCorrectnessTemplate {

    private Class<?> className = InvokeSpecialCastByte.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{byte.class, byte.class}};
    private Object[][] methodArgs = {new Object[]{(byte) 15, (byte) 18}};

    @Test
    public void testSuperMethodIsCalled() {
        InvokeSpecialCastByte testme = new InvokeSpecialCastByte();
        InvokeVirtualCastByte check = new InvokeVirtualCastByte();
        //the normalAdd method of the testme class is wrong on purpose, the class should call the superclass one
        Assertions.assertTrue(testme.add((byte) 15, (byte) 18));
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
