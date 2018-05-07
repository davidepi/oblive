package testclasses.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;

public class InvokeInterfaceVoid
{
    public InvokeInterfaceVoid()
    {

    }

    @Obfuscation
    public void print(AdderInterface interf, int a, int b)
    {
        interf.print(a,b);
    }
}