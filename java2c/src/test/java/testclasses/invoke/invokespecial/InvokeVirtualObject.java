package testclasses.invoke.invokespecial;

import eu.fbk.hardening.annotation.Obfuscation;

public class InvokeVirtualObject
{
    @Obfuscation
    public String concatenate(String a, char b)
    {
        return normalcat(a,b);
    }
    public String normalcat(String a, char b)
    {
        return a+b;
    }
}
