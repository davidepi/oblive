package testclasses.exceptions.invoke.invokespecial;

import it.se.obfuscator.Obfuscate;

public class InvokeVirtualDouble
{
    public InvokeVirtualDouble()
    {

    }

    @Obfuscate
    public double add(double a, double b)
    {
        return normalAdd(a,b);
    }

    public double normalAdd(double a, double b)
    {
        int c = 1/0;
        return a + b;
    }
}