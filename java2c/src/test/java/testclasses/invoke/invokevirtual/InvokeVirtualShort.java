package testclasses.invoke.invokevirtual;

import eu.fbk.hardening.annotation.Obfuscation;

public class InvokeVirtualShort
{
    public InvokeVirtualShort()
    {

    }

    @Obfuscation
    public short add(short a, short b)
    {
        return normalAdd(a,b);
    }

    public short normalAdd(short a, short b)
    {
        return (short)(a + b);
    }
}