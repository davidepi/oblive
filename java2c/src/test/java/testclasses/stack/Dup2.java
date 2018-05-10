package testclasses.stack;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class Dup2
{
    public Dup2()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public double exec()
    {
        double a = 2.5;
        double b = 3.5;
        return a = b++;
    }
}
