package eu.fbk.hardening.tests.invoke.invokespecial;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testclasses.invoke.invokespecial.InvokeSpecialBoolean;
import testclasses.invoke.invokevirtual.InvokeVirtualBoolean;

public class TestInvokeSpecialBoolean extends AbstractTestMethodTemplate {

    private Class<?> className = testclasses.invoke.invokespecial.InvokeSpecialBoolean.class;
    private String[] methodTest = {"and", "and", "and", "and"};
    private Class[][] methodParam = {new Class[]{boolean.class, boolean.class}, new Class[]{boolean.class, boolean.class},
            new Class[]{boolean.class, boolean.class}, new Class[]{boolean.class, boolean.class}};
    private Object[][] methodArgs = {new Object[]{false, false}, new Object[]{true, false},
            new Object[]{false, true}, new Object[]{true, true}};

    @Test
    public void testSuperMethodIsCalled() {
        InvokeSpecialBoolean testme = new InvokeSpecialBoolean();
        InvokeVirtualBoolean check = new InvokeVirtualBoolean();
        //the normalAdd method of the testme class is wrong on purpose, the class should call the superclass one
        Assertions.assertEquals(check.normalAnd(true, true), testme.and(true, true));
        Assertions.assertNotEquals(check.normalAnd(true, true), testme.normalAnd(true, true));
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
