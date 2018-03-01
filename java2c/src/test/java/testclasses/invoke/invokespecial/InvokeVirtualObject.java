package testclasses.invoke.invokespecial;

import it.se.obfuscator.Obfuscate;

public class InvokeVirtualObject
{
    @Obfuscate
    public String concatenate(String a, char b)
    {
        return normalcat(a,b);
    }
    public String normalcat(String a, char b)
    {
        return a+b;
    }
}
