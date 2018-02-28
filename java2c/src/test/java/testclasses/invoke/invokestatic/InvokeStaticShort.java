package testclasses.invoke.invokestatic;

import it.se.obfuscator.Obfuscate;

public class InvokeStaticShort
{
    public InvokeStaticShort()
    {

    }

    @Obfuscate
    public short add(short a, short b)
    {
        return normalAdd(a,b);
    }

    public static short normalAdd(short a, short b)
    {
        return (short)(a + b);
    }
}