package testclasses.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;

public class InvokeInterfaceObject
{
    public InvokeInterfaceObject()
    {

    }

    @Obfuscation
    public String concatenate(AdderInterface interf, String a, char b)
    {
        return interf.concatenate(a,b);
    }
}