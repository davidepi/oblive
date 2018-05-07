package testclasses.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;

public class InvokeInterfaceBoolean
{
    public InvokeInterfaceBoolean()
    {

    }

    @Obfuscation
    public boolean and(AdderInterface interf, boolean a, boolean b)
    {
        return interf.and(a,b);
    }
}