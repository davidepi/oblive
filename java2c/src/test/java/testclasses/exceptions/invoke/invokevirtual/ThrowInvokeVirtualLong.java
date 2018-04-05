package testclasses.exceptions.invoke.invokevirtual;

import it.se.obfuscator.Obfuscate;

public class ThrowInvokeVirtualLong
{
    public ThrowInvokeVirtualLong()
    {

    }

    @Obfuscate
    public int div(int a)
    {
        return (int)normalDiv(a,0);
    }

    public long normalDiv(int a, int b)
    {
        return (long)(a / b);
    }
}