package testclasses.exceptions.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowInvokeStaticChar
{
    public ThrowInvokeStaticChar()
    {

    }

    @Obfuscation
    public int div(int a)
    {
        return (int)normalDiv(a,0);
    }

    public static char normalDiv(int a, int b)
    {
        return (char)(a / b);
    }
}
