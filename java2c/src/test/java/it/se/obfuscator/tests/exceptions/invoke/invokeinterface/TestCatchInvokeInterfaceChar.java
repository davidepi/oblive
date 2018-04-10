package it.se.obfuscator.tests.exceptions.invoke.invokeinterface;

import it.se.obfuscator.helpers.AbstractTestMethodTemplate;
import testclasses.exceptions.invoke.invokeinterface.DivisionInterface;
import testclasses.exceptions.invoke.invokeinterface.ImplementedInterface;

public class TestCatchInvokeInterfaceChar extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.exceptions.invoke.invokeinterface.CatchInvokeInterfaceChar.class;
    private String[] methodTest = {"div"};
    private Class[][] methodParam = {new Class[]{DivisionInterface.class,char.class}};
    private Object[][] methodArgs = {new Object[]{new ImplementedInterface(),(char)10}};


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