package it.oblive.correctness.invoke.invokespecial;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testclasses.invoke.invokespecial.InvokeSpecialCastChar;
import testclasses.invoke.invokevirtual.InvokeVirtualCastChar;


public class TestInvokeSpecialCastChar extends AbstractTestCorrectnessTemplate {

    private Class<?> className = InvokeSpecialCastChar.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{char.class, char.class}};
    private Object[][] methodArgs = {new Object[]{'A', 'b'}};

    @Test
    public void testSuperMethodIsCalled() {
        InvokeSpecialCastChar testme = new InvokeSpecialCastChar();
        InvokeVirtualCastChar check = new InvokeVirtualCastChar();
        //the normalAdd method of the testme class is wrong on purpose, the class should call the superclass one
        Assertions.assertTrue(testme.add((char) 15, (char) 18));
        Assertions.assertNotEquals(check.normalAdd((char) 15, (char) 18), testme.normalAdd((char) 15, (char) 18));
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
