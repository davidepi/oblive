package testclasses.exceptions.invoke.invokeinterface;

import it.se.obfuscator.Obfuscate;

public class ThrowInvokeInterfaceFloat
{
    public ThrowInvokeInterfaceFloat()
    {

    }

    @Obfuscate
    public float div(DivisionInterface interf, float a)
    {
        return interf.div(a);
    }
}
