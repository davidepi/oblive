package testclasses.exceptions.invoke.invokespecial;

import it.se.obfuscator.Obfuscate;

public class ThrowInvokeSpecialByte extends InvokeVirtualByte
{
    public ThrowInvokeSpecialByte()
    {

    }

    @Obfuscate
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
