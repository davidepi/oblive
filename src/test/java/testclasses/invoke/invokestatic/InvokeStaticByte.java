package testclasses.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeStaticByte
{
    public InvokeStaticByte()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public byte add(byte a, byte b)
    {
        return normalAdd(a, b);
    }

    public static byte normalAdd(byte a, byte b)
    {
        return (byte) (a + b);
    }
}