package it.se.obfuscator.tests.invoke.invokeinterface;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;
import testclasses.invoke.invokeinterface.AdderInterface;
import testclasses.invoke.invokeinterface.ImplementedInterface;

public class TestInvokeInterfaceByte extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.invoke.invokeinterface.InvokeInterfaceByte.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{AdderInterface.class, byte.class,byte.class}};
    private Object[][] methodArgs = {new Object[]{new ImplementedInterface(), (byte)15,(byte)18}};


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
