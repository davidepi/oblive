package testclasses.exceptions.invoke.invokeinterface;

import it.se.obfuscator.Obfuscate;

public class ThrowInvokeInterfaceDouble
{
    public ThrowInvokeInterfaceDouble()
    {

    }

    @Obfuscate
    public double div(DivisionInterface interf, double a)
    {
        return interf.div(a);
    }
}
