package testclasses.invoke.invokestatic;

import it.se.obfuscator.Obfuscate;

public class InvokeStaticByte
{
    public InvokeStaticByte()
    {

    }

    @Obfuscate
    public byte add(byte a, byte b)
    {
        return normalAdd(a,b);
    }

    public static byte normalAdd(byte a, byte b)
    {
        return (byte)(a + b);
    }
}