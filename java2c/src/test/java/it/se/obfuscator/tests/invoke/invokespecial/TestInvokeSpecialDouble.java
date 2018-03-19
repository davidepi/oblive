package it.se.obfuscator.tests.invoke.invokespecial;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;
import org.junit.Test;
import testclasses.invoke.invokespecial.InvokeSpecialDouble;
import testclasses.invoke.invokevirtual.InvokeVirtualDouble;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestInvokeSpecialDouble extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.invoke.invokespecial.InvokeSpecialDouble.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{double.class,double.class}};
    private Object[][] methodArgs = {new Object[]{3.14159265359,2.7182818284}};

    @Test
    public void testSuperMethodIsCalled()
    {
        InvokeSpecialDouble testme = new InvokeSpecialDouble();
        InvokeVirtualDouble check = new InvokeVirtualDouble();
        //the normalAdd method of the testme class is wrong on purpose, the class should call the superclass one
        assertEquals(check.normalAdd(15.,18.),testme.add(15.,18.),0.1);
        assertNotEquals(check.normalAdd(15.,18.),testme.normalAdd(15.,18.));
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
