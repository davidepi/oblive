package testclasses.exceptions.invoke.invokestatic;

import it.se.obfuscator.Obfuscate;

public class ThrowInvokeStaticDouble
{
    public ThrowInvokeStaticDouble()
    {

    }

    @Obfuscate
    public int div(int a)
    {
        return (int)normalDiv(a,0);
    }

    public static double normalDiv(int a, int b)
    {
        return (double)(a / b);
    }
}
