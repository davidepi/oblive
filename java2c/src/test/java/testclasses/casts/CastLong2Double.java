package testclasses.casts; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotation.Obfuscation;

public class CastLong2Double
{
    public CastLong2Double()
    {

    }

    @Obfuscation
    public double exec(long a)
    {
        return (double)(a+a);
    }

}
