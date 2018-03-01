package testclasses.invoke.invokeinterface;

import it.se.obfuscator.Obfuscate;

public class InvokeInterfaceBoolean
{
    public InvokeInterfaceBoolean()
    {

    }

    @Obfuscate
    public boolean and(AdderInterface interf, boolean a, boolean b)
    {
        return interf.and(a,b);
    }
}