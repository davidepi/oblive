package testclasses.exceptions.invoke.invokevirtual;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowInvokeVirtualLong
{
    public ThrowInvokeVirtualLong()
    {

    }

    @Obfuscation
    public int div(int a)
    {
        return (int)normalDiv(a,0);
    }

    public long normalDiv(int a, int b)
    {
        return (long)(a / b);
    }
}