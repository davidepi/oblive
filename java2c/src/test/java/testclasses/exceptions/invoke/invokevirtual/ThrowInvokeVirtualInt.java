package testclasses.exceptions.invoke.invokevirtual;

import it.se.obfuscator.Obfuscate;

public class ThrowInvokeVirtualInt
{
    public ThrowInvokeVirtualInt()
    {

    }

    @Obfuscate
    public int div(int a)
    {
        return normalDiv(a,0);
    }

    public int normalDiv(int a, int b)
    {
        return a / b;
    }
}