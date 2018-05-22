package testclasses.invoke.invokespecial;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeSpecialCastByte extends InvokeVirtualCastByte
{
    public InvokeSpecialCastByte()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    @Override
    public boolean add(byte a, byte b)
    {
        return super.normalAdd(a, b)==(byte)(a+b);
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public byte normalAdd(byte a, byte b)
    {
        return (byte) (a - b);
    }
}