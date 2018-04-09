package testclasses.exceptions.invoke.invokestatic;

import it.se.obfuscator.Obfuscate;

public class ThrowInvokeStaticLong
{
    public ThrowInvokeStaticLong()
    {

    }

    @Obfuscate
    public int div(int a)
    {
        return (int)normalDiv(a,0);
    }

    public static long normalDiv(int a, int b)
    {
        return (long)(a / b);
    }
}
