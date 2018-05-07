package testclasses.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;

public class InvokeStaticDouble
{
    public InvokeStaticDouble()
    {

    }

    @Obfuscation
    public double add(double a, double b)
    {
        return normalAdd(a,b);
    }

    public static double normalAdd(double a, double b)
    {
        return a + b;
    }
}