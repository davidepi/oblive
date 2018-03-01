package testclasses.invoke.invokeinterface;

import it.se.obfuscator.Obfuscate;

public class InvokeInterfaceShort
{
    public InvokeInterfaceShort()
    {

    }

    @Obfuscate
    public short add(AdderInterface interf, short a, short b)
    {
        return interf.add(a,b);
    }
}