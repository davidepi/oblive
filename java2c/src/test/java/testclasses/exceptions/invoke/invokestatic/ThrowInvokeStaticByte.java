package testclasses.exceptions.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowInvokeStaticByte
{
    public ThrowInvokeStaticByte()
    {

    }

    @Obfuscation
    public int div(int a)
    {
        return normalDiv(a,0);
    }

    public static byte normalDiv(int a, int b)
    {
        return (byte)(a / b);
    }
}
