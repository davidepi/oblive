package testclasses;

import it.se.obfuscator.Obfuscate;

public class AdderInvokeMethod
{
    public AdderInvokeMethod()
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