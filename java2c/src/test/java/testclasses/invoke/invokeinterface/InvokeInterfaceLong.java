package testclasses.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeInterfaceLong
{
    public InvokeInterfaceLong()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public long add(AdderInterface interf, long a, long b)
    {
        return interf.add(a, b);
    }
}