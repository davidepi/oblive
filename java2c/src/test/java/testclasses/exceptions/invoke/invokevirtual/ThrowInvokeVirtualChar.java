package testclasses.exceptions.invoke.invokevirtual;

import it.se.obfuscator.Obfuscate;

public class ThrowInvokeVirtualChar
{
    public ThrowInvokeVirtualChar()
    {

    }

    @Obfuscate
    public int div(int a)
    {
        return (int)normalDiv(a,0);
    }

    public char normalDiv(int a, int b)
    {
        return (char)(a / b);
    }
}