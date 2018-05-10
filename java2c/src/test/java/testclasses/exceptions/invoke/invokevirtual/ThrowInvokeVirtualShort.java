package testclasses.exceptions.invoke.invokevirtual;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowInvokeVirtualShort
{
    public ThrowInvokeVirtualShort()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int div(int a)
    {
        return (int) normalDiv(a, 0);
    }

    public short normalDiv(int a, int b)
    {
        return (short) (a / b);
    }
}