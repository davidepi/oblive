package testclasses.exceptions.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowInvokeStaticInt
{
    public ThrowInvokeStaticInt()
    {

    }

    @Obfuscation
    public int div(int a)
    {
        return normalDiv(a,0);
    }

    public static int normalDiv(int a, int b)
    {
        return a / b;
    }
}
