package testclasses.invoke.invokestatic;

import it.se.obfuscator.Obfuscate;

public class InvokeStaticLong
{
    public InvokeStaticLong()
    {

    }

    @Obfuscate
    public long add(long a, long b)
    {
        return normalAdd(a,b);
    }
    public static long normalAdd(long a, long b)
    {
        return a + b;
    }
}