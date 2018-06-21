package testclasses.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowInvokeInterfaceInt
{
    public ThrowInvokeInterfaceInt()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int div(DivisionInterface interf, int a)
    {
        return interf.div(a);
    }
}
