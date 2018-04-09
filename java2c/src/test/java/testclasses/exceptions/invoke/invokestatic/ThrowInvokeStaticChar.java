package testclasses.exceptions.invoke.invokestatic;

import it.se.obfuscator.Obfuscate;

public class ThrowInvokeStaticChar
{
    public ThrowInvokeStaticChar()
    {

    }

    @Obfuscate
    public int div(int a)
    {
        return (int)normalDiv(a,0);
    }

    public static char normalDiv(int a, int b)
    {
        return (char)(a / b);
    }
}
