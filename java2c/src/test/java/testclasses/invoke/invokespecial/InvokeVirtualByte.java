package testclasses.invoke.invokespecial;

import eu.fbk.hardening.annotation.Obfuscation;

public class InvokeVirtualByte
{
    public InvokeVirtualByte()
    {

    }

    @Obfuscation
    public byte add(byte a, byte b)
    {
        return normalAdd(a,b);
    }

    public byte normalAdd(byte a, byte b)
    {
        return (byte)(a + b);
    }
}