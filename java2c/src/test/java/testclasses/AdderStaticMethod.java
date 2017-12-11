package testclasses;

import it.se.obfuscator.Obfuscate;

public class AdderStaticMethod
{
    public AdderStaticMethod()
    {

    }

    @Obfuscate
    public static int add(int a, int b)
    {
        return a + b;
    }
}
