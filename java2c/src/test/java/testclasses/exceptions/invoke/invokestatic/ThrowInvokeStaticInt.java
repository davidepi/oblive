package testclasses.exceptions.invoke.invokestatic;

import it.se.obfuscator.Obfuscate;

public class ThrowInvokeStaticInt
{
    public ThrowInvokeStaticInt()
    {

    }

    @Obfuscate
    public int div(int a)
    {
        return normalDiv(a,0);
    }

    public static int normalDiv(int a, int b)
    {
        return a / b;
    }
}
