package testclasses.casts; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotation.Obfuscation;

public class CastFloat2Double
{
    public CastFloat2Double()
    {

    }

    @Obfuscation
    public double exec(float a)
    {
        return (double) (a+a);
    }

}
