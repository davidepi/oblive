package testclasses.invoke.invokespecial;

import it.se.obfuscator.Obfuscate;
import testclasses.invoke.invokevirtual.InvokeVirtualByte;
import testclasses.invoke.invokevirtual.InvokeVirtualInt;

public class InvokeSpecialByte extends InvokeVirtualByte
{
    public InvokeSpecialByte()
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