package testclasses.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;

public class InvokeStaticShort
{
    public InvokeStaticShort()
    {

    }

    @Obfuscation
    public short add(short a, short b)
    {
        return normalAdd(a,b);
    }

    public static short normalAdd(short a, short b)
    {
        return (short)(a + b);
    }
}