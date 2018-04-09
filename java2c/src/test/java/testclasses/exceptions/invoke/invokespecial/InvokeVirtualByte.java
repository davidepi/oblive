package testclasses.exceptions.invoke.invokespecial;

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
        int c = 1/0;
        return (byte)(a + b);
    }
}