package eu.fbk.hardening.tests.invoke.invokespecial;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;
import org.junit.Test;
import testclasses.invoke.invokespecial.InvokeSpecialCastChar;
import testclasses.invoke.invokevirtual.InvokeVirtualCastChar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestInvokeSpecialCastChar extends AbstractTestMethodTemplate
{

    private Class<?> className = InvokeSpecialCastChar.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{char.class, char.class}};
    private Object[][] methodArgs = {new Object[]{'A', 'b'}};

    @Test
    public void testSuperMethodIsCalled()
    {
        InvokeSpecialCastChar testme = new InvokeSpecialCastChar();
        InvokeVirtualCastChar check = new InvokeVirtualCastChar();
        //the normalAdd method of the testme class is wrong on purpose, the class should call the superclass one
        assertEquals(true, testme.add((char) 15, (char) 18));
        assertNotEquals(check.normalAdd((char) 15, (char) 18), testme.normalAdd((char) 15, (char) 18));
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
