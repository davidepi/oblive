package testclasses.casts; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotation.Obfuscation;

public class CastDouble2Long
{
    public CastDouble2Long()
    {

    }

    @Obfuscation
    public long exec(double a)
    {
        return (long)(a+a);
    }

}
