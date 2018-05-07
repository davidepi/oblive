package testclasses.invoke.invokespecial;

import eu.fbk.hardening.annotation.Obfuscation;

public class InvokeSpecialLong extends InvokeVirtualLong
{
    public InvokeSpecialLong()
    {

    }

    @Obfuscation
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