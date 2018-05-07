package testclasses.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;

public class InvokeInterfaceChar
{
    public InvokeInterfaceChar()
    {

    }

    @Obfuscation
    public char add(AdderInterface interf, char a, char b)
    {
        return interf.add(a,b);
    }
}