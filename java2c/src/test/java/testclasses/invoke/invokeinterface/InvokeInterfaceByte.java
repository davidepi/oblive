package testclasses.invoke.invokeinterface;

import it.se.obfuscator.Obfuscate;

public class InvokeInterfaceByte
{
    public InvokeInterfaceByte()
    {

    }

    @Obfuscate
    public byte add(AdderInterface interf, byte a, byte b)
    {
        return interf.add(a,b);
    }
}