package testclasses.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowInvokeInterfaceInt
{
    public ThrowInvokeInterfaceInt()
    {

    }

    @Obfuscation
    public int div(DivisionInterface interf, int a)
    {
        return interf.div(a);
    }
}
