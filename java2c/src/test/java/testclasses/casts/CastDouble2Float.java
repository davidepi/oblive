package testclasses.casts; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotation.Obfuscation;

public class CastDouble2Float
{
    public CastDouble2Float()
    {

    }

    @Obfuscation
    public float exec(double a)
    {
        return (float)(a+a);
    }

}
