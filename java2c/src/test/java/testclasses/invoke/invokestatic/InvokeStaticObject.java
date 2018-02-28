package testclasses.invoke.invokestatic;

import it.se.obfuscator.Obfuscate;

public class InvokeStaticObject
{
    @Obfuscate
    public String concatenate(String a, char b)
    {
        return normalcat(a,b);
    }
    public static String normalcat(String a, char b)
    {
        return a+b;
    }
}
