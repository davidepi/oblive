package testclasses.invoke.invokevirtual;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeVirtualCastByte
{
    public InvokeVirtualCastByte()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean add(byte a, byte b)
    {
        return normalAdd(a, b)==(byte)(a+b);
    }

    public byte normalAdd(byte a, byte b)
    {
        return (byte) (a + b);
    }
}