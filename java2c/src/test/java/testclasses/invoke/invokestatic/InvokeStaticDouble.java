package testclasses.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeStaticDouble
{
    public InvokeStaticDouble()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public double add(double a, double b)
    {
        return normalAdd(a, b);
    }

    public static double normalAdd(double a, double b)
    {
        return a + b;
    }
}