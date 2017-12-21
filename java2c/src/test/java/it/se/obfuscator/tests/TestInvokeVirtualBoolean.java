package it.se.obfuscator.tests;

import it.se.obfuscator.helpers.TestMethodTemplate;
import testclasses.AdderInvokeMethodDouble;
import testclasses.TesterInvokeMethodBoolean;

public class TestInvokeVirtualBoolean extends TestMethodTemplate
{

    @Override
    public String getTestClassName()
    {
        return TesterInvokeMethodBoolean.class.getName();
    }

    @Override
    public String getMethodName()
    {
        return "and";
    }

    @Override
    public Class[] getMethodParamsSignature()
    {
        return new Class[]{boolean.class,boolean.class};
    }

    @Override
    public Object[] getMethodParams()
    {
        return new Object[]{true,true};
    }

    @Override
    public Object getMethodExpectedResult()
    {
        return true;
    }
}
