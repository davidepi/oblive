package testclasses;

import it.se.obfuscator.Obfuscate;

public class AdderInvokeMethodVoid
{
    public AdderInvokeMethodVoid()
    {

    }

    @Obfuscate
    public boolean add(int a, int b)
    {
        print(a,b);
        return true;
    }

    public void print(int a, int b)
    {
        System.out.println(a+b);
    }
}