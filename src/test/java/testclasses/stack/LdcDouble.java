package testclasses.stack;


import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class LdcDouble
{
    public LdcDouble()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public double exec()
    {
        double a = 3.5;
        double b = -0.5;
        return a + b;
    }
}
