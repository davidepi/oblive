package testclasses.exceptions.invoke.invokespecial;

import it.se.obfuscator.Obfuscate;

public class InvokeVirtualLong
{
    public InvokeVirtualLong()
    {

    }

    @Obfuscate
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