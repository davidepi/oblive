package testclasses.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;

public class InvokeInterfaceLong
{
    public InvokeInterfaceLong()
    {

    }

    @Obfuscation
    public long add(AdderInterface interf, long a, long b)
    {
        return interf.add(a,b);
    }
}