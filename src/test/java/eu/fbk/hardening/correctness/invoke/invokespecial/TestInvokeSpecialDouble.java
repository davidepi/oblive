package eu.fbk.hardening.correctness.invoke.invokespecial;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testclasses.invoke.invokespecial.InvokeSpecialDouble;
import testclasses.invoke.invokevirtual.InvokeVirtualDouble;


public class TestInvokeSpecialDouble extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.invoke.invokespecial.InvokeSpecialDouble.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{double.class, double.class}};
    private Object[][] methodArgs = {new Object[]{3.14159265359, 2.7182818284}};

    @Test
    public void testSuperMethodIsCalled() {
        InvokeSpecialDouble testme = new InvokeSpecialDouble();
        InvokeVirtualDouble check = new InvokeVirtualDouble();
        //the normalAdd method of the testme class is wrong on purpose, the class should call the superclass one
        Assertions.assertEquals(check.normalAdd(15., 18.), testme.add(15., 18.), 0.1);
        Assertions.assertNotEquals(check.normalAdd(15., 18.), testme.normalAdd(15., 18.));
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
