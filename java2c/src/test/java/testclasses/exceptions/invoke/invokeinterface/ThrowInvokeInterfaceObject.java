package testclasses.exceptions.invoke.invokeinterface;

import it.se.obfuscator.Obfuscate;

public class ThrowInvokeInterfaceObject
{
    public ThrowInvokeInterfaceObject()
    {

    }

    @Obfuscate
    public String div(DivisionInterface interf, String a)
    {
        return interf.div(a);
    }
}
