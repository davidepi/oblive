package it.se.obfuscator.tests;

import it.se.obfuscator.helpers.TestMethodTemplate;
import testclasses.InvokeVirtualVoid;

public class TestInvokeVirtualVoid extends TestMethodTemplate
{

    @Override
    public String getTestClassName()
    {
        return InvokeVirtualVoid.class.getName();
    }

    @Override
    public String getMethodName()
    {
        return "add";
    }

    @Override
    public Class[] getMethodParamsSignature()
    {
        return new Class[]{int.class,int.class};
    }

    @Override
    public Object[] getMethodParams()
    {
        return new Object[]{15,21};
    }

    @Override
    public Object getMethodExpectedResult()
    {
        return null;
    }
}
