package testclasses.exceptions.invoke.invokevirtual;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowInvokeVirtualChar
{
    public ThrowInvokeVirtualChar()
    {

    }

    @Obfuscation
    public int div(int a)
    {
        return (int)normalDiv(a,0);
    }

    public char normalDiv(int a, int b)
    {
        return (char)(a / b);
    }
}