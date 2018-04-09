package testclasses.exceptions.invoke.invokeinterface;

import it.se.obfuscator.Obfuscate;

public class ThrowInvokeInterfaceLong
{
    public ThrowInvokeInterfaceLong()
    {

    }

    @Obfuscate
    public long div(DivisionInterface interf, long a)
    {
        return interf.div(a);
    }
}
