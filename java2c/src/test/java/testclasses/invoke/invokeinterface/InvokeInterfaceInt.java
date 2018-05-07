package testclasses.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;

public class InvokeInterfaceInt
{
    public InvokeInterfaceInt()
    {

    }

    @Obfuscation
    public int add(AdderInterface interf, int a, int b)
    {
        return interf.add(a,b);
    }
}