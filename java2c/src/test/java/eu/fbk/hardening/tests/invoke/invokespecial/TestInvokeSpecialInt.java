package eu.fbk.hardening.tests.invoke.invokespecial;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;
import org.junit.Test;
import testclasses.invoke.invokespecial.InvokeSpecialInt;
import testclasses.invoke.invokevirtual.InvokeVirtualInt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestInvokeSpecialInt extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.invoke.invokespecial.InvokeSpecialInt.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{int.class,int.class}};
    private Object[][] methodArgs = {new Object[]{1000000,-2000000}};

    @Test
    public void testSuperMethodIsCalled()
    {
        InvokeSpecialInt testme = new InvokeSpecialInt();
        InvokeVirtualInt check = new InvokeVirtualInt();
        //the normalAdd method of the testme class is wrong on purpose, the class should call the superclass one
        assertEquals(check.normalAdd(15,18),testme.add(15,18));
        assertNotEquals(check.normalAdd(15,18),testme.normalAdd(15,18));
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
