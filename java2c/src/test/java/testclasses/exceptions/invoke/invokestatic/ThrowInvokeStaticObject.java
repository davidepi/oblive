package testclasses.exceptions.invoke.invokestatic;

import it.se.obfuscator.Obfuscate;

public class ThrowInvokeStaticObject
{
    public ThrowInvokeStaticObject()
    {

    }

    @Obfuscate
    public int div(int a)
    {
        return ((Integer)normalDiv(a,0));
    }

    public static Object normalDiv(int a, int b)
    {
        return a / b;
    }
}
