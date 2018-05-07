package testclasses.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;

public class InvokeStaticObject
{
    @Obfuscation
    public String concatenate(String a, char b)
    {
        return normalcat(a,b);
    }
    public static String normalcat(String a, char b)
    {
        return a+b;
    }
}
