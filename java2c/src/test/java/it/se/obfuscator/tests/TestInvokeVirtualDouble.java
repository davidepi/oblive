package it.se.obfuscator.tests;

import it.se.obfuscator.helpers.TestMethodTemplate;
import testclasses.InvokeVirtualDouble;

public class TestInvokeVirtualDouble extends TestMethodTemplate
{

    @Override
    public String getTestClassName()
    {
        return InvokeVirtualDouble.class.getName();
    }

    @Override
    public String getMethodName()
    {
        return "add";
    }

    @Override
    public Class[] getMethodParamsSignature()
    {
        return new Class[]{double.class,double.class};
    }

    @Override
    public Object[] getMethodParams()
    {
        return new Object[]{3.5,0.5};
    }

    @Override
    public Object getMethodExpectedResult()
    {
        return 4.0;
    }
}
