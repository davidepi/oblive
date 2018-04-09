package testclasses.exceptions.invoke.invokespecial;

import it.se.obfuscator.Obfuscate;

public class ThrowInvokeSpecialObject extends InvokeVirtualObject
{
    public ThrowInvokeSpecialObject()
    {

    }

    @Obfuscate
    @Override
    public String concatenate(String a, char b)
    {
        return super.normalcat(a,b);
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public String normalcat(String a, char b)
    {
        return "WRONG INVOKESPECIAL!";
    }
}
