package testclasses.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowInvokeInterfaceByte
{
    public ThrowInvokeInterfaceByte()
    {

    }

    @Obfuscation
    public byte div(DivisionInterface interf, byte a)
    {
        return interf.div(a);
    }
}
