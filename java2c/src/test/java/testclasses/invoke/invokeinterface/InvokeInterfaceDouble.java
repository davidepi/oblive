package testclasses.invoke.invokeinterface;

import it.se.obfuscator.Obfuscate;

public class InvokeInterfaceDouble
{
    public InvokeInterfaceDouble()
    {

    }

    @Obfuscate
    public double add(AdderInterface interf, double a, double b)
    {
        return interf.add(a,b);
    }
}