package testclasses.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;

public class InvokeInterfaceShort
{
    public InvokeInterfaceShort()
    {

    }

    @Obfuscation
    public short add(AdderInterface interf, short a, short b)
    {
        return interf.add(a,b);
    }
}