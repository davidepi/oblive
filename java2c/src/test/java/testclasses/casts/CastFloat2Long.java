package testclasses.casts; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotation.Obfuscation;

public class CastFloat2Long
{
    public CastFloat2Long()
    {

    }

    @Obfuscation
    public long exec(float a)
    {
        return (long)(a+a);
    }

}
