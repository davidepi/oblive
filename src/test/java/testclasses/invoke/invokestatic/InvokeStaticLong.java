package testclasses.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeStaticLong
{
    public InvokeStaticLong()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public long add(long a, long b)
    {
        return normalAdd(a, b);
    }

    public static long normalAdd(long a, long b)
    {
        return a + b;
    }
}