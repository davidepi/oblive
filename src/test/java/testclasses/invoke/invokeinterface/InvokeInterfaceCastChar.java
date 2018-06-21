package testclasses.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeInterfaceCastChar
{
    public InvokeInterfaceCastChar()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean add(AdderInterface interf, char a, char b)
    {
        return interf.add(a, b)==(char)(a+b);
    }
}