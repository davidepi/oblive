package eu.fbk.hardening.tests.invoke.invokespecial;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;
import org.junit.Test;
import testclasses.invoke.invokespecial.InvokeSpecialCastByte;
import testclasses.invoke.invokevirtual.InvokeVirtualCastByte;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestInvokeSpecialCastByte extends AbstractTestMethodTemplate
{

    private Class<?> className = InvokeSpecialCastByte.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{byte.class, byte.class}};
    private Object[][] methodArgs = {new Object[]{(byte) 15, (byte) 18}};

    @Test
    public void testSuperMethodIsCalled()
    {
        InvokeSpecialCastByte testme = new InvokeSpecialCastByte();
        InvokeVirtualCastByte check = new InvokeVirtualCastByte();
        //the normalAdd method of the testme class is wrong on purpose, the class should call the superclass one
        assertEquals(check.normalAdd((byte) 15, (byte) 18), testme.add((byte) 15, (byte) 18));
        assertNotEquals(check.normalAdd((byte) 15, (byte) 18), testme.normalAdd((byte) 15, (byte) 18));
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
