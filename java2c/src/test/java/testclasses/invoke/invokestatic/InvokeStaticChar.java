package testclasses.invoke.invokestatic;

import it.se.obfuscator.Obfuscate;

public class InvokeStaticChar
{
    public InvokeStaticChar()
    {

    }

    @Obfuscate
    public char add(char a, char b)
    {
        return normalAdd(a,b);
    }

    public static char normalAdd(char a, char b)
    {
        return (char)(a + b);
    }
}