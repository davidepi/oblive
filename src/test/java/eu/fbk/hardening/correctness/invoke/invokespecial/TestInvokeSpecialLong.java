package eu.fbk.hardening.correctness.invoke.invokespecial;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testclasses.invoke.invokespecial.InvokeSpecialLong;
import testclasses.invoke.invokevirtual.InvokeVirtualLong;


public class TestInvokeSpecialLong extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.invoke.invokespecial.InvokeSpecialLong.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{long.class, long.class}};
    private Object[][] methodArgs = {new Object[]{0x200000001L, 0x400000002L}};

    @Test
    public void testSuperMethodIsCalled() {
        InvokeSpecialLong testme = new InvokeSpecialLong();
        InvokeVirtualLong check = new InvokeVirtualLong();
        //the normalAdd method of the testme class is wrong on purpose, the class should call the superclass one
        Assertions.assertEquals(check.normalAdd(15L, 18L), testme.add(15L, 18L));
        Assertions.assertNotEquals(check.normalAdd(15L, 18L), testme.normalAdd(15L, 18L));
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
