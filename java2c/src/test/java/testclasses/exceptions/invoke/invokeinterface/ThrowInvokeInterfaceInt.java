package testclasses.exceptions.invoke.invokeinterface;

import it.se.obfuscator.Obfuscate;

public class ThrowInvokeInterfaceInt
{
    public ThrowInvokeInterfaceInt()
    {

    }

    @Obfuscate
    public int div(DivisionInterface interf, int a)
    {
        return interf.div(a);
    }
}
