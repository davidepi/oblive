package eu.fbk.hardening.tests.invoke.invokespecial;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testclasses.invoke.invokespecial.InvokeSpecialShort;
import testclasses.invoke.invokevirtual.InvokeVirtualShort;


public class TestInvokeSpecialShort extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.invoke.invokespecial.InvokeSpecialShort.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{short.class, short.class}};
    private Object[][] methodArgs = {new Object[]{(short) 15000, (short) 1000}};

    @Test
    public void testSuperMethodIsCalled() {
        InvokeSpecialShort testme = new InvokeSpecialShort();
        InvokeVirtualShort check = new InvokeVirtualShort();
        //the normalAdd method of the testme class is wrong on purpose, the class should call the superclass one
        Assertions.assertEquals(check.normalAdd((short) 15, (short) 18), testme.add((short) 15, (short) 18));
        Assertions.assertNotEquals(check.normalAdd((short) 15, (short) 18), testme.normalAdd((short) 15, (short) 18));
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
