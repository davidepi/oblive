package testclasses.invoke.invokespecial;

import it.se.obfuscator.Obfuscate;

public class InvokeSpecialShort extends InvokeVirtualShort
{
    public InvokeSpecialShort()
    {

    }

    @Obfuscate
    @Override
    public short add(short a, short b)
    {
        return super.normalAdd(a,b);
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public short normalAdd(short a, short b)
    {
        return (short)(a - b);
    }
}