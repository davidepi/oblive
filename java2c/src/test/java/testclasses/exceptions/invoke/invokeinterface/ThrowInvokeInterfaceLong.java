package testclasses.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowInvokeInterfaceLong
{
    public ThrowInvokeInterfaceLong()
    {

    }

    @Obfuscation
    public long div(DivisionInterface interf, long a)
    {
        return interf.div(a);
    }
}
