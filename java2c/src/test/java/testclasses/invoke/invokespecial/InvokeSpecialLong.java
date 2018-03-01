package testclasses.invoke.invokespecial;

import it.se.obfuscator.Obfuscate;
import testclasses.invoke.invokevirtual.InvokeVirtualInt;
import testclasses.invoke.invokevirtual.InvokeVirtualLong;

public class InvokeSpecialLong extends InvokeVirtualLong
{
    public InvokeSpecialLong()
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