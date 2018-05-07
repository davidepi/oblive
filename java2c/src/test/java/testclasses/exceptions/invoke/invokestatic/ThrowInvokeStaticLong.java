package testclasses.exceptions.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowInvokeStaticLong
{
    public ThrowInvokeStaticLong()
    {

    }

    @Obfuscation
    public int div(int a)
    {
        return (int)normalDiv(a,0);
    }

    public static long normalDiv(int a, int b)
    {
        return (long)(a / b);
    }
}
