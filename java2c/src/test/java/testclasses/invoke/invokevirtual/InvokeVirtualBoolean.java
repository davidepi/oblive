package testclasses.invoke.invokevirtual;

import eu.fbk.hardening.annotation.Obfuscation;

public class InvokeVirtualBoolean
{
    public InvokeVirtualBoolean()
    {

    }

    @Obfuscation
    public boolean and(boolean a, boolean b)
    {
        return normalAnd(a,b);
    }
    public boolean normalAnd(boolean a, boolean b)
    {
        return a && b;
    }
}