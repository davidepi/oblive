package testclasses.invoke.invokespecial;

import it.se.obfuscator.Obfuscate;

public class InvokeVirtualShort
{
    public InvokeVirtualShort()
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