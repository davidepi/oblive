package testclasses.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowInvokeInterfaceDouble
{
    public ThrowInvokeInterfaceDouble()
    {

    }

    @Obfuscation
    public double div(DivisionInterface interf, double a)
    {
        return interf.div(a);
    }
}
