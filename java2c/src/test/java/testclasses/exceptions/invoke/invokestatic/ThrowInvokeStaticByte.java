package testclasses.exceptions.invoke.invokestatic;

import it.se.obfuscator.Obfuscate;

public class ThrowInvokeStaticByte
{
    public ThrowInvokeStaticByte()
    {

    }

    @Obfuscate
    public int div(int a)
    {
        return normalDiv(a,0);
    }

    public static byte normalDiv(int a, int b)
    {
        return (byte)(a / b);
    }
}
