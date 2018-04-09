package testclasses.exceptions.invoke.invokeinterface;

import it.se.obfuscator.Obfuscate;

public class ThrowInvokeInterfaceShort
{
    public ThrowInvokeInterfaceShort()
    {

    }

    @Obfuscate
    public short div(DivisionInterface interf, short a)
    {
        return interf.div(a);
    }
}
