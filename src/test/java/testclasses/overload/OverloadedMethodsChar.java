package testclasses.overload;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class OverloadedMethodsChar
{
    public OverloadedMethodsChar()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public static int add(int a, double b)
    {
        return a + (int)b;
    }

    @Obfuscation(protections =  Protections.TO_NATIVE_CODE)
    public static char add(char a, char b)
    {
        return (char) (a+b);
    }
}
