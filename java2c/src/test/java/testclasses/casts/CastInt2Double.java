package testclasses.casts; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotation.Obfuscation;

public class CastInt2Double
{
    public CastInt2Double()
    {

    }

    @Obfuscation
    public double exec(int a)
    {
        return (double)(a+a);
    }

}
