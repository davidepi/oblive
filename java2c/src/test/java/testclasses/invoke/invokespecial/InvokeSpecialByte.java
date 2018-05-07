package testclasses.invoke.invokespecial;

import eu.fbk.hardening.annotation.Obfuscation;

public class InvokeSpecialByte extends InvokeVirtualByte
{
    public InvokeSpecialByte()
    {

    }

    @Obfuscation
    @Override
    public byte add(byte a, byte b)
    {
        return super.normalAdd(a,b);
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public byte normalAdd(byte a, byte b)
    {
        return (byte)(a - b);
    }
}