package it.se.obfuscator.tests;

import it.se.obfuscator.helpers.TestMethodTemplate;
import testclasses.InvokeVirtualObject;

public class TestInvokeVirtualObject extends TestMethodTemplate
{

    @Override
    public String getTestClassName()
    {
        return InvokeVirtualObject.class.getName();
    }

    @Override
    public String getMethodName()
    {
        return "concatenate";
    }

    @Override
    public Class[] getMethodParamsSignature()
    {
        return new Class[]{java.lang.String.class,char.class};
    }

    @Override
    public Object[] getMethodParams()
    {
        return new Object[]{"hello world",'!'};
    }

    @Override
    public Object getMethodExpectedResult()
    {
        return "hello world!";
    }
}
