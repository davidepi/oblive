package testclasses.stack;

import eu.fbk.hardening.annotation.Obfuscation;

public class Dup2
{
    public Dup2()
    {

    }

    @Obfuscation
    public double exec()
    {
        double a = 2.5;
        double b = 3.5;
        return a=b++;
    }
}
