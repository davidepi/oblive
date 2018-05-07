package testclasses.casts; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotation.Obfuscation;

public class CastInt2Float
{
    public CastInt2Float()
    {

    }

    @Obfuscation
    public float exec(int a)
    {
        return (float)(a+a);
    }

}
