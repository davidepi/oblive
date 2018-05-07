package testclasses.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowInvokeInterfaceFloat
{
    public ThrowInvokeInterfaceFloat()
    {

    }

    @Obfuscation
    public float div(DivisionInterface interf, float a)
    {
        return interf.div(a);
    }
}
