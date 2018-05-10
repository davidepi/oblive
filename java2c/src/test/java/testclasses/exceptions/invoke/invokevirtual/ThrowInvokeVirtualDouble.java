package testclasses.exceptions.invoke.invokevirtual;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowInvokeVirtualDouble
{
    public ThrowInvokeVirtualDouble()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int div(int a)
    {
        return (int) normalDiv(a, 0);
    }

    public double normalDiv(int a, int b)
    {
        return (double) (a / b);
    }
}