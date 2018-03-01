package testclasses.invoke.invokeinterface;

import it.se.obfuscator.Obfuscate;

public class InvokeInterfaceChar
{
    public InvokeInterfaceChar()
    {

    }

    @Obfuscate
    public char add(AdderInterface interf, char a, char b)
    {
        return interf.add(a,b);
    }
}