package testclasses.stack;

import it.se.obfuscator.Obfuscate;

public class Dup2
{
    public Dup2()
    {

    }

    @Obfuscate
    public double exec()
    {
        double a = 2.5;
        double b = 3.5;
        return a=b++;
    }
}
