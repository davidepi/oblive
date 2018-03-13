package testclasses.arithmetic; //when changing this, remember to change also the variable in it.se.obfuscator.helpers

import it.se.obfuscator.Obfuscate;

public class DRem
{
    public DRem()
    {

    }

    @Obfuscate
    public double exec(double a, double b)
    {
        return a % b;
    }

}
