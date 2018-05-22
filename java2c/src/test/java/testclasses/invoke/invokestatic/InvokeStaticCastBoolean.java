package testclasses.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeStaticCastBoolean
{
    public InvokeStaticCastBoolean()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean and(boolean a, boolean b)
    {
        return normalAnd(a, b)==(boolean)a&&b;
    }

    public static boolean normalAnd(boolean a, boolean b)
    {
        return a && b;
    }
}