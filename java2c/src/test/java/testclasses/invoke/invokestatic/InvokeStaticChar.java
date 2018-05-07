package testclasses.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;

public class InvokeStaticChar
{
    public InvokeStaticChar()
    {

    }

    @Obfuscation
    public char add(char a, char b)
    {
        return normalAdd(a,b);
    }

    public static char normalAdd(char a, char b)
    {
        return (char)(a + b);
    }
}