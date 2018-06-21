package testclasses.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeInterfaceBoolean
{
    public InvokeInterfaceBoolean()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean and(AdderInterface interf, boolean a, boolean b)
    {
        return interf.and(a, b);
    }
}