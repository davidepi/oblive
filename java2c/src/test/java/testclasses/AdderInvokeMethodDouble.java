package testclasses;

import it.se.obfuscator.Obfuscate;

public class AdderInvokeMethodDouble
{
    public AdderInvokeMethodDouble()
    {

    }

    @Obfuscate
    public double add(double a, double b)
    {
        return normalAdd(a,b);
    }

    public double normalAdd(double a, double b)
    {
        return a + b;
    }
}