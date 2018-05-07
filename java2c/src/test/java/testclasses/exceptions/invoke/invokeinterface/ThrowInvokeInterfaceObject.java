package testclasses.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowInvokeInterfaceObject
{
    public ThrowInvokeInterfaceObject()
    {

    }

    @Obfuscation
    public String div(DivisionInterface interf, String a)
    {
        return interf.div(a);
    }
}
