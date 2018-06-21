package testclasses.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeInterfaceChar
{
    public InvokeInterfaceChar()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public char add(AdderInterface interf, char a, char b)
    {
        return interf.add(a, b);
    }
}