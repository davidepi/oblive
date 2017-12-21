package testclasses;

import it.se.obfuscator.Obfuscate;

public class AdderInvokeMethodLong
{
    public AdderInvokeMethodLong()
    {

    }

    @Obfuscate
    public long add(long a, long b)
    {
        return normalAdd(a,b);
    }
    public long normalAdd(long a, long b)
    {
        return a + b;
    }
}