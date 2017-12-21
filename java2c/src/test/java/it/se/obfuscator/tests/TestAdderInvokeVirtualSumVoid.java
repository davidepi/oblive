package it.se.obfuscator.tests;

import it.se.obfuscator.helpers.TestMethodTemplate;
import testclasses.AdderInvokeMethodInt;
import testclasses.AdderInvokeMethodVoid;

public class TestAdderInvokeVirtualSumVoid extends TestMethodTemplate
{

    @Override
    public String getTestClassName()
    {
        return AdderInvokeMethodVoid.class.getName();
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
