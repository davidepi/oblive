package testclasses.invoke.invokevirtual;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeVirtualCastBoolean
{
    public InvokeVirtualCastBoolean()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean and(boolean a, boolean b)
    {
        return normalAnd(a, b)==a&&b;
    }

    public boolean normalAnd(boolean a, boolean b)
    {
        return a && b;
    }
}