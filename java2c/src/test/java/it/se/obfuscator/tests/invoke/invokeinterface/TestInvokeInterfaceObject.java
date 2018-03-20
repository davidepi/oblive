package it.se.obfuscator.tests.invoke.invokeinterface;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;
import testclasses.invoke.invokeinterface.AdderInterface;
import testclasses.invoke.invokeinterface.ImplementedInterface;

public class TestInvokeInterfaceObject extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.invoke.invokeinterface.InvokeInterfaceObject.class;
    private String[] methodTest = {"concatenate"};
    private Class[][] methodParam = {new Class[]{AdderInterface.class,String.class,char.class}};
    private Object[][] methodArgs = {new Object[]{new ImplementedInterface(), "hello world",'!'}};


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
