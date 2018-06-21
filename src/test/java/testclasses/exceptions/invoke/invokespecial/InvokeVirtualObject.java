package testclasses.exceptions.invoke.invokespecial;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeVirtualObject
{
    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public String concatenate(String a, char b)
    {
        return normalcat(a, b);
    }

    public String normalcat(String a, char b)
    {
        int c = 1 / 0;
        return a + b;
    }
}
