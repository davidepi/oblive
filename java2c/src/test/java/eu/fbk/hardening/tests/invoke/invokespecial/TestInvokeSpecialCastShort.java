package eu.fbk.hardening.tests.invoke.invokespecial;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;
import org.junit.Test;
import testclasses.invoke.invokespecial.InvokeSpecialCastShort;
import testclasses.invoke.invokevirtual.InvokeVirtualCastShort;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestInvokeSpecialCastShort extends AbstractTestMethodTemplate
{

    private Class<?> className = InvokeSpecialCastShort.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{short.class, short.class}};
    private Object[][] methodArgs = {new Object[]{(short) 15000, (short) 1000}};

    @Test
    public void testSuperMethodIsCalled()
    {
        InvokeSpecialCastShort testme = new InvokeSpecialCastShort();
        InvokeVirtualCastShort check = new InvokeVirtualCastShort();
        //the normalAdd method of the testme class is wrong on purpose, the class should call the superclass one
        assertEquals(true, testme.add((short) 15, (short) 18));
        assertNotEquals(check.normalAdd((short) 15, (short) 18), testme.normalAdd((short) 15, (short) 18));
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
