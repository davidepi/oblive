package testclasses.invoke.invokeinterface;

import it.se.obfuscator.Obfuscate;

public class InvokeInterfaceObject
{
    public InvokeInterfaceObject()
    {

    }

    @Obfuscate
    public String concatenate(AdderInterface interf, String a, char b)
    {
        return interf.concatenate(a,b);
    }
}