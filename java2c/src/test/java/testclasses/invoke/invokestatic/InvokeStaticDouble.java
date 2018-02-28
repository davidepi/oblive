package testclasses.invoke.invokestatic;

import it.se.obfuscator.Obfuscate;

public class InvokeStaticDouble
{
    public InvokeStaticDouble()
    {

    }

    @Obfuscate
    public double add(double a, double b)
    {
        return normalAdd(a,b);
    }

    public static double normalAdd(double a, double b)
    {
        return a + b;
    }
}