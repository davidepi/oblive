package testclasses.invoke.invokeinterface;

import it.se.obfuscator.Obfuscate;

public class InvokeInterfaceVoid
{
    public InvokeInterfaceVoid()
    {

    }

    @Obfuscate
    public void print(AdderInterface interf, int a, int b)
    {
        interf.print(a,b);
    }
}