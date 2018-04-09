package testclasses.exceptions.invoke.invokeinterface;

import it.se.obfuscator.Obfuscate;

public class ThrowInvokeInterfaceBoolean
{
    public ThrowInvokeInterfaceBoolean()
    {

    }

    @Obfuscate
    public boolean div(DivisionInterface interf, boolean a)
    {
        return interf.div(a);
    }
}
