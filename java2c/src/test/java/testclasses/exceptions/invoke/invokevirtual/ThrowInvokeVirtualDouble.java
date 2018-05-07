package testclasses.exceptions.invoke.invokevirtual;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowInvokeVirtualDouble
{
    public ThrowInvokeVirtualDouble()
    {

    }

    @Obfuscation
    public int div(int a)
    {
        return (int)normalDiv(a,0);
    }

    public double normalDiv(int a, int b)
    {
        return (double)(a / b);
    }
}