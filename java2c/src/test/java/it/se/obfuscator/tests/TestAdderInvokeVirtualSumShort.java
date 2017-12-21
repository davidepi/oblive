package it.se.obfuscator.tests;

import it.se.obfuscator.helpers.TestMethodTemplate;
import testclasses.AdderInvokeMethodShort;

public class TestAdderInvokeVirtualSumShort extends TestMethodTemplate
{

    @Override
    public String getTestClassName()
    {
        return AdderInvokeMethodShort.class.getName();
    }

    @Override
    public String getMethodName()
    {
        return "add";
    }

    @Override
    public Class[] getMethodParamsSignature()
    {
        return new Class[]{short.class,short.class};
    }

    @Override
    public Object[] getMethodParams()
    {
        return new Object[]{(short)3,(short)1};
    }

    @Override
    public Object getMethodExpectedResult()
    {
        return (short)4;
    }
}
