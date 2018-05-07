package testclasses.exceptions.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowInvokeStaticFloat
{
    public ThrowInvokeStaticFloat()
    {

    }

    @Obfuscation
    public int div(int a)
    {
        return (int)normalDiv(a,0);
    }

    public static float normalDiv(int a, int b)
    {
        return (float)(a / b);
    }
}
