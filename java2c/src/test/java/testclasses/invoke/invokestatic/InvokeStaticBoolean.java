package testclasses.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;

public class InvokeStaticBoolean
{
    public InvokeStaticBoolean()
    {

    }

    @Obfuscation
    public boolean and(boolean a, boolean b)
    {
        return normalAnd(a,b);
    }
    public static boolean normalAnd(boolean a, boolean b)
    {
        return a && b;
    }
}