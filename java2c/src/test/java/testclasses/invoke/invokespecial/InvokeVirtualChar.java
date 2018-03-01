package testclasses.invoke.invokespecial;

import it.se.obfuscator.Obfuscate;

public class InvokeVirtualChar
{
    public InvokeVirtualChar()
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