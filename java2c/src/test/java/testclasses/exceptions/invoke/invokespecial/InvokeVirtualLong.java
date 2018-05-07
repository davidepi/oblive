package testclasses.exceptions.invoke.invokespecial;

import eu.fbk.hardening.annotation.Obfuscation;

public class InvokeVirtualLong
{
    public InvokeVirtualLong()
    {

    }

    @Obfuscation
    public long add(long a, long b)
    {
        return normalAdd(a,b);
    }
    public long normalAdd(long a, long b)
    {
        int c = 1/0;
        return a + b;
    }
}