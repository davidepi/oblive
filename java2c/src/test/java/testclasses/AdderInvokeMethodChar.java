package testclasses;

import it.se.obfuscator.Obfuscate;

public class AdderInvokeMethodChar
{
    public AdderInvokeMethodChar()
    {

    }

    @Obfuscate
    public char add(char a, char b)
    {
        return normalAdd(a,b);
    }

    public char normalAdd(char a, char b)
    {
        return (char)(a + b);
    }
}