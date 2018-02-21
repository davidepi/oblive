package it.se.obfuscator.tests;

import it.se.obfuscator.helpers.TestMethodTemplate;
import testclasses.AdderInvokeMethodLong;

public class TestAdderInvokeVirtualSumLong extends TestMethodTemplate
{

    @Override
    public String getTestClassName()
    {
        return AdderInvokeMethodLong.class.getName();
    }

    @Override
    public String getMethodName()
    {
        return "add";
    }

    @Override
    public Class[] getMethodParamsSignature()
    {
        return new Class[]{long.class,long.class};
    }

    @Override
    public Object[] getMethodParams()
    {
        return new Object[]{0x200000001L,0x400000002L};
    }

    @Override
    public Object getMethodExpectedResult()
    {
        return 0x600000003L;
    }
}
