package testclasses;

import it.se.obfuscator.Obfuscate;

public class AdderInvokeMethodVoid
{
    public AdderInvokeMethodVoid()
    {

    }

    @Obfuscate
    public void add(int a, int b)
    {
        print(a,b);
    }

    public void print(int a, int b)
    {
        System.out.println(a+b);
    }
}