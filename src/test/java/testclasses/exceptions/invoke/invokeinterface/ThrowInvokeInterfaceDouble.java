package testclasses.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowInvokeInterfaceDouble
{
    public ThrowInvokeInterfaceDouble()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public double div(DivisionInterface interf, double a)
    {
        return interf.div(a);
    }
}
