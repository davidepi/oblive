package testclasses.invoke.invokespecial;

import it.se.obfuscator.Obfuscate;
import testclasses.invoke.invokevirtual.InvokeVirtualInt;
import testclasses.invoke.invokevirtual.InvokeVirtualObject;

public class InvokeSpecialObject extends InvokeVirtualObject
{
    public InvokeSpecialObject()
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