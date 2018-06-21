package testclasses.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeInterfaceFloat
{
    public InvokeInterfaceFloat()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public float add(AdderInterface interf, float a, float b)
    {
        return interf.add(a, b);
    }
}