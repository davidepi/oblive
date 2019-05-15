package eu.fbk.hardening.tests.invoke.invokespecial;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testclasses.invoke.invokespecial.InvokeSpecialFloat;
import testclasses.invoke.invokevirtual.InvokeVirtualFloat;


public class TestInvokeSpecialFloat extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.invoke.invokespecial.InvokeSpecialFloat.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{float.class, float.class}};
    private Object[][] methodArgs = {new Object[]{3.5f, -2.5f}};

    @Test
    public void testSuperMethodIsCalled() {
        InvokeSpecialFloat testme = new InvokeSpecialFloat();
        InvokeVirtualFloat check = new InvokeVirtualFloat();
        //the normalAdd method of the testme class is wrong on purpose, the class should call the superclass one
        Assertions.assertEquals(check.normalAdd(15.f, 18.f), testme.add(15.f, 18.f), 0.1);
        Assertions.assertNotEquals(check.normalAdd(15.f, 18.f), testme.normalAdd(15.f, 18.f));
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
