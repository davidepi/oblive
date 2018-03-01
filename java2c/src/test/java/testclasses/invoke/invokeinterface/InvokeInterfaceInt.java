package testclasses.invoke.invokeinterface;

import it.se.obfuscator.Obfuscate;

public class InvokeInterfaceInt
{
    public InvokeInterfaceInt()
    {

    }

    @Obfuscate
    public int add(AdderInterface interf, int a, int b)
    {
        return interf.add(a,b);
    }
}