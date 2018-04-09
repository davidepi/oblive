package testclasses.exceptions.invoke.invokestatic;

import it.se.obfuscator.Obfuscate;

public class ThrowInvokeStaticFloat
{
    public ThrowInvokeStaticFloat()
    {

    }

    @Obfuscate
    public int div(int a)
    {
        return (int)normalDiv(a,0);
    }

    public static float normalDiv(int a, int b)
    {
        return (float)(a / b);
    }
}
