package testclasses.exceptions.invoke.invokevirtual;

import it.se.obfuscator.Obfuscate;

public class ThrowInvokeVirtualByte
{
    public ThrowInvokeVirtualByte()
    {

    }

    @Obfuscate
    public int div(int a)
    {
        return normalDiv(a,0);
    }

    public byte normalDiv(int a, int b)
    {
        return (byte)(a / b);
    }
}