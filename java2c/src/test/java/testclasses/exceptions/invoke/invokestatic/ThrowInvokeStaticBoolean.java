package testclasses.exceptions.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowInvokeStaticBoolean
{
    public ThrowInvokeStaticBoolean()
    {

    }

    @Obfuscation
    public int div(int a)
    {
        return normalDiv(a,0)?0:-1;
    }

    public static boolean normalDiv(int a, int b)
    {
        return (a / b)>0;
    }
}
