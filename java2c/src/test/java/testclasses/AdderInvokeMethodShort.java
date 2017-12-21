package testclasses;

import it.se.obfuscator.Obfuscate;

public class AdderInvokeMethodShort
{
    public AdderInvokeMethodShort()
    {

    }

    @Obfuscate
    public short add(short a, short b)
    {
        return normalAdd(a,b);
    }

    public short normalAdd(short a, short b)
    {
        return (short)(a + b);
    }
}