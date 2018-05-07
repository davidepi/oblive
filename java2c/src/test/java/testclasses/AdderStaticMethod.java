package testclasses;

import eu.fbk.hardening.annotation.Obfuscation;

public class AdderStaticMethod
{
    public AdderStaticMethod()
    {

    }

    @Obfuscation
    public static int add(int a, int b)
    {
        return a + b;
    }
}
