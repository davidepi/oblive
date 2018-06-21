package testclasses.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowInvokeInterfaceObject
{
    public ThrowInvokeInterfaceObject()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public String div(DivisionInterface interf, String a)
    {
        return interf.div(a);
    }
}
