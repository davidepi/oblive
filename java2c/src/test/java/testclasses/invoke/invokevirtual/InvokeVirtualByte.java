package testclasses.invoke.invokevirtual;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeVirtualByte
{
    public InvokeVirtualByte()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public byte add(byte a, byte b)
    {
        return normalAdd(a, b);
    }

    public byte normalAdd(byte a, byte b)
    {
        return (byte) (a + b);
    }
}