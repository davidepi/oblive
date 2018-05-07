package testclasses.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowInvokeInterfaceShort
{
    public ThrowInvokeInterfaceShort()
    {

    }

    @Obfuscation
    public short div(DivisionInterface interf, short a)
    {
        return interf.div(a);
    }
}
