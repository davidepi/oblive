package testclasses.exceptions.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowInvokeStaticDouble
{
    public ThrowInvokeStaticDouble()
    {

    }

    @Obfuscation
    public int div(int a)
    {
        return (int)normalDiv(a,0);
    }

    public static double normalDiv(int a, int b)
    {
        return (double)(a / b);
    }
}
