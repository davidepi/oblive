package testclasses.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeStaticObject
{
    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public String concatenate(String a, char b)
    {
        return normalcat(a, b);
    }

    public static String normalcat(String a, char b)
    {
        return a + b;
    }
}
