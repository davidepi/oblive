package testclasses.exceptions.invoke.invokespecial;

import it.se.obfuscator.Obfuscate;

public class ThrowInvokeSpecialShort extends InvokeVirtualShort
{
    public ThrowInvokeSpecialShort()
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
