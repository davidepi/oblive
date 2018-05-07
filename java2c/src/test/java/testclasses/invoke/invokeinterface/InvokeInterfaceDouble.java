package testclasses.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;

public class InvokeInterfaceDouble
{
    public InvokeInterfaceDouble()
    {

    }

    @Obfuscation
    public double add(AdderInterface interf, double a, double b)
    {
        return interf.add(a,b);
    }
}