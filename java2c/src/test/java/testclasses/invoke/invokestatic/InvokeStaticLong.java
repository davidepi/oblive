package testclasses.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;

public class InvokeStaticLong
{
    public InvokeStaticLong()
    {

    }

    @Obfuscation
    public long add(long a, long b)
    {
        return normalAdd(a,b);
    }
    public static long normalAdd(long a, long b)
    {
        return a + b;
    }
}