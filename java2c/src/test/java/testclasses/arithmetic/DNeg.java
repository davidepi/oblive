package testclasses.arithmetic; //when changing this, remember to change also the variable in it.se.obfuscator.helpers

import it.se.obfuscator.Obfuscate;

public class DNeg
{
    public DNeg()
    {

    }

    @Obfuscate
    public double exec(double a)
    {
        return -a;
    }

}
