package testclasses.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeInterfaceVoid
{
    public InvokeInterfaceVoid()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public void print(AdderInterface interf, int a, int b)
    {
        interf.print(a, b);
    }
}