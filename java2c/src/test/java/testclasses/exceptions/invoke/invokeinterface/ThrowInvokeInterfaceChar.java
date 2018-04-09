package testclasses.exceptions.invoke.invokeinterface;

import it.se.obfuscator.Obfuscate;

public class ThrowInvokeInterfaceChar
{
    public ThrowInvokeInterfaceChar()
    {

    }

    @Obfuscate
    public char div(DivisionInterface interf, char a)
    {
        return interf.div(a);
    }
}
