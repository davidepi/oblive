package eu.fbk.hardening.tests.invoke.invokespecial;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testclasses.invoke.invokespecial.InvokeSpecialByte;
import testclasses.invoke.invokevirtual.InvokeVirtualByte;

public class TestInvokeSpecialByte extends AbstractTestMethodTemplate {

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
    public String getTestMethodName(int position) {
        return methodTest[position];
    }

    @Override
    public int getTestMethodSize() {
        return methodTest.length;
    }

    @Override
    public Class<?>[] getTestMethodParams(int position) {
        return methodParam[position];
    }

    @Override
    public Object[] getTestMethodArgs(int position) {
        return methodArgs[position];
    }
}
