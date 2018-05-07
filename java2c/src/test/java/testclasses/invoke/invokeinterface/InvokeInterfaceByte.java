package testclasses.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;

public class InvokeInterfaceByte
{
    public InvokeInterfaceByte()
    {

    }

    @Obfuscation
    public byte add(AdderInterface interf, byte a, byte b)
    {
        return interf.add(a,b);
    }
}