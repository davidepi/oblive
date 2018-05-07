package testclasses.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;

public class InvokeInterfaceFloat
{
    public InvokeInterfaceFloat()
    {

    }

    @Obfuscation
    public float add(AdderInterface interf, float a, float b)
    {
        return interf.add(a,b);
    }
}