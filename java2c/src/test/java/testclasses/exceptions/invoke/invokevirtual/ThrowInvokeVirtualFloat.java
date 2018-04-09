package testclasses.exceptions.invoke.invokevirtual;

import it.se.obfuscator.Obfuscate;

public class ThrowInvokeVirtualFloat
{
    public ThrowInvokeVirtualFloat()
    {

    }

    @Obfuscate
    public int div(int a)
    {
        return (int)normalDiv(a,0);
    }

    public float normalDiv(int a, int b)
    {
        return (float)(a / b);
    }
}