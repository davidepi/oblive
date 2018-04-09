package testclasses.exceptions.invoke.invokestatic;

import it.se.obfuscator.Obfuscate;

public class ThrowInvokeStaticShort
{
    public ThrowInvokeStaticShort()
    {

    }

    @Obfuscate
    public int div(int a)
    {
        return (int)normalDiv(a,0);
    }

    public static short normalDiv(int a, int b)
    {
        return (short)(a / b);
    }
}
