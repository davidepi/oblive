package testclasses.exceptions.invoke.invokespecial;

import it.se.obfuscator.Obfuscate;

public class ThrowInvokeSpecialLong extends InvokeVirtualLong
{
    public ThrowInvokeSpecialLong()
    {

    }

    @Obfuscate
    @Override
    public long add(long a, long b)
    {
        return super.normalAdd(a,b);
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public long normalAdd(long a, long b)
    {
        return a - b;
    }
}
