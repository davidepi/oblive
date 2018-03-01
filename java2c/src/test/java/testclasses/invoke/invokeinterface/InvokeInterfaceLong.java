package testclasses.invoke.invokeinterface;

import it.se.obfuscator.Obfuscate;

public class InvokeInterfaceLong
{
    public InvokeInterfaceLong()
    {

    }

    @Obfuscate
    public long add(AdderInterface interf, long a, long b)
    {
        return interf.add(a,b);
    }
}