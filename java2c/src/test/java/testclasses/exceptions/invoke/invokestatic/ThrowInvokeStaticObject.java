package testclasses.exceptions.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowInvokeStaticObject
{
    public ThrowInvokeStaticObject()
    {

    }

    @Obfuscation
    public int div(int a)
    {
        return ((Integer)normalDiv(a,0));
    }

    public static Object normalDiv(int a, int b)
    {
        return a / b;
    }
}
