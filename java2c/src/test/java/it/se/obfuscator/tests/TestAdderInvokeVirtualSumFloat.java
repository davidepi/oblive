package it.se.obfuscator.tests;

import it.se.obfuscator.helpers.TestMethodTemplate;
import testclasses.AdderInvokeMethodFloat;

public class TestAdderInvokeVirtualSumFloat extends TestMethodTemplate
{

    @Override
    public String getTestClassName()
    {
        return AdderInvokeMethodFloat.class.getName();
    }

    @Override
    public String getMethodName()
    {
        return "add";
    }

    @Override
    public Class[] getMethodParamsSignature()
    {
        return new Class[]{float.class,float.class};
    }

    @Override
    public Object[] getMethodParams()
    {
        return new Object[]{3.5f,0.5f};
    }

    @Override
    public Object getMethodExpectedResult()
    {
        return 4.f;
    }
}
