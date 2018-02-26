package it.se.obfuscator.tests;

import it.se.obfuscator.helpers.TestMethodTemplate;
import testclasses.InvokeVirtualChar;

public class TestInvokeVirtualChar extends TestMethodTemplate
{

    @Override
    public String getTestClassName()
    {
        return InvokeVirtualChar.class.getName();
    }

    @Override
    public String getMethodName()
    {
        return "add";
    }

    @Override
    public Class[] getMethodParamsSignature()
    {
        return new Class[]{char.class,char.class};
    }

    @Override
    public Object[] getMethodParams()
    {
        return new Object[]{'A','!'};
    }

    @Override
    public Object getMethodExpectedResult()
    {
        return 'b';
    }
}
