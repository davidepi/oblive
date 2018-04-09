package testclasses.exceptions.invoke.invokevirtual;

import it.se.obfuscator.Obfuscate;

public class ThrowInvokeVirtualShort
{
    public ThrowInvokeVirtualShort()
    {

    }

    @Obfuscate
    public int div(int a)
    {
        return (int)normalDiv(a,0);
    }

    public short normalDiv(int a, int b)
    {
        return (short)(a / b);
    }
}