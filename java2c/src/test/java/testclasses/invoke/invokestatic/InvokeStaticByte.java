package testclasses.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;

public class InvokeStaticByte
{
    public InvokeStaticByte()
    {

    }

    @Obfuscation
    public byte add(byte a, byte b)
    {
        return normalAdd(a,b);
    }

    public static byte normalAdd(byte a, byte b)
    {
        return (byte)(a + b);
    }
}