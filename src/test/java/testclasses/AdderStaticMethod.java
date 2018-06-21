package testclasses;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class AdderStaticMethod
{
    public AdderStaticMethod()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public static int add(int a, int b)
    {
        return a + b;
    }
}
