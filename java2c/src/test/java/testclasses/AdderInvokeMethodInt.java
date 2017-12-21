package testclasses;

import it.se.obfuscator.Obfuscate;

public class AdderInvokeMethodInt
{
    public AdderInvokeMethodInt()
    {

    }

    @Obfuscate
    public int add(int a, int b)
    {
        return normalAdd(a,b);
    }

    public int normalAdd(int a, int b)
    {
        return a + b;
    }
}