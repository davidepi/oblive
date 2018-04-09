package testclasses.exceptions.invoke.invokeinterface;

import it.se.obfuscator.Obfuscate;

public class ThrowInvokeInterfaceByte
{
    public ThrowInvokeInterfaceByte()
    {

    }

    @Obfuscate
    public byte div(DivisionInterface interf, byte a)
    {
        return interf.div(a);
    }
}
