package testclasses.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowInvokeInterfaceBoolean
{
    public ThrowInvokeInterfaceBoolean()
    {

    }

    @Obfuscation
    public boolean div(DivisionInterface interf, boolean a)
    {
        return interf.div(a);
    }
}
