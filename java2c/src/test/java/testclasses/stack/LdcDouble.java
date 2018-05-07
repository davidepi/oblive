package testclasses.stack;


import eu.fbk.hardening.annotation.Obfuscation;

public class LdcDouble
{
    public LdcDouble()
    {

    }

    @Obfuscation
    public double exec()
    {
        double a = 3.5;
        double b = -0.5;
        return a+b;
    }
}
