package testclasses.stack;


import it.se.obfuscator.Obfuscate;

public class LdcDouble
{
    public LdcDouble()
    {

    }

    @Obfuscate
    public double exec()
    {
        double a = 3.5;
        double b = -0.5;
        return a+b;
    }
}
