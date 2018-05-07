package testclasses.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowInvokeInterfaceChar
{
    public ThrowInvokeInterfaceChar()
    {

    }

    @Obfuscation
    public char div(DivisionInterface interf, char a)
    {
        return interf.div(a);
    }
}
