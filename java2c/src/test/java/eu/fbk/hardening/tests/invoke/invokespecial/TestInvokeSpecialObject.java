package eu.fbk.hardening.tests.invoke.invokespecial;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;
import org.junit.Test;
import testclasses.invoke.invokespecial.InvokeSpecialObject;
import testclasses.invoke.invokevirtual.InvokeVirtualObject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestInvokeSpecialObject extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.invoke.invokespecial.InvokeSpecialObject.class;
    private String[] methodTest = {"concatenate"};
    private Class[][] methodParam = {new Class[]{String.class, char.class}};
    private Object[][] methodArgs = {new Object[]{"hello world", '!'}};

    @Test
    public void testSuperMethodIsCalled()
    {
        InvokeSpecialObject testme = new InvokeSpecialObject();
        InvokeVirtualObject check = new InvokeVirtualObject();
        //the normalAdd method of the testme class is wrong on purpose, the class should call the superclass one
        assertEquals(check.concatenate("hello", 'w'), testme.concatenate("hello", 'w'));
        assertNotEquals(check.normalcat("hello", 'w'), testme.normalcat("hello", 'w'));
    }

    @Override
    public Class<?> getTestClass()
    {
        return className;
    }

    @Override
    public String getTestMethodName(int position)
    {
        return methodTest[position];
    }

    @Override
    public int getTestMethodSize()
    {
        return methodTest.length;
    }

    @Override
    public Class<?>[] getTestMethodParams(int position)
    {
        return methodParam[position];
    }

    @Override
    public Object[] getTestMethodArgs(int position)
    {
        return methodArgs[position];
    }
}
