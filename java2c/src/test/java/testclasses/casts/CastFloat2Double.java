package testclasses.casts; //when changing this, remember to change also the variable in it.se.obfuscator.helpers

import it.se.obfuscator.Obfuscate;

public class CastFloat2Double
{
    public CastFloat2Double()
    {

    }

    @Obfuscate
    public double exec(float a)
    {
        return (double) (a+a);
    }

}
