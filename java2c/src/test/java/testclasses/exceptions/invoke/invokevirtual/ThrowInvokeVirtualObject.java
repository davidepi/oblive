package testclasses.exceptions.invoke.invokevirtual;

import it.se.obfuscator.Obfuscate;

public class ThrowInvokeVirtualObject
{
    public ThrowInvokeVirtualObject()
    {

    }

    @Obfuscate
    public int div(int a)
    {
        return ((Integer)normalDiv(a,0));
    }

    public Object normalDiv(int a, int b)
    {
        return a / b;
    }
}