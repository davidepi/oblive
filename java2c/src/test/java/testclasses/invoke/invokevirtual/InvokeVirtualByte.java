package testclasses.invoke.invokevirtual;

import it.se.obfuscator.Obfuscate;

public class InvokeVirtualByte
{
    public InvokeVirtualByte()
    {

    }

    @Obfuscate
    public byte add(byte a, byte b)
    {
        return normalAdd(a,b);
    }

    public byte normalAdd(byte a, byte b)
    {
        return (byte)(a + b);
    }
}