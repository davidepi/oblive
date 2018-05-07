package eu.fbk.hardening.tests.invoke.invokespecial;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;
import org.junit.Test;
import testclasses.invoke.invokespecial.InvokeSpecialLong;
import testclasses.invoke.invokevirtual.InvokeVirtualLong;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestInvokeSpecialLong extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.invoke.invokespecial.InvokeSpecialLong.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{long.class,long.class}};
    private Object[][] methodArgs = {new Object[]{0x200000001L,0x400000002L}};

    @Test
    public void testSuperMethodIsCalled()
    {
        InvokeSpecialLong testme = new InvokeSpecialLong();
        InvokeVirtualLong check = new InvokeVirtualLong();
        //the normalAdd method of the testme class is wrong on purpose, the class should call the superclass one
        assertEquals(check.normalAdd(15L,18L),testme.add(15L,18L));
        assertNotEquals(check.normalAdd(15L,18L),testme.normalAdd(15L,18L));
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
