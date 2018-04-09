package testclasses.exceptions.invoke.invokevirtual;

import it.se.obfuscator.Obfuscate;

public class ThrowInvokeVirtualDouble
{
    public ThrowInvokeVirtualDouble()
    {

    }

    @Obfuscate
    public int div(int a)
    {
        return (int)normalDiv(a,0);
    }

    public double normalDiv(int a, int b)
    {
        return (double)(a / b);
    }
}