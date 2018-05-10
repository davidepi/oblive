package testclasses.exceptions.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowInvokeStaticInt
{
    public ThrowInvokeStaticInt()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int div(int a)
    {
        return normalDiv(a, 0);
    }

    public static int normalDiv(int a, int b)
    {
        return a / b;
    }
}
