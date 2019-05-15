package eu.fbk.hardening.tests.invoke.invokespecial;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testclasses.invoke.invokespecial.InvokeSpecialChar;
import testclasses.invoke.invokevirtual.InvokeVirtualChar;


public class TestInvokeSpecialChar extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.invoke.invokespecial.InvokeSpecialChar.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{char.class, char.class}};
    private Object[][] methodArgs = {new Object[]{'A', 'b'}};

    @Test
    public void testSuperMethodIsCalled() {
        InvokeSpecialChar testme = new InvokeSpecialChar();
        InvokeVirtualChar check = new InvokeVirtualChar();
        //the normalAdd method of the testme class is wrong on purpose, the class should call the superclass one
        Assertions.assertEquals(check.normalAdd((char) 15, (char) 18), testme.add((char) 15, (char) 18));
        Assertions.assertNotEquals(check.normalAdd((char) 15, (char) 18), testme.normalAdd((char) 15, (char) 18));
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
