package testclasses.casts; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class CastLong2Float
{
    public CastLong2Float()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public float exec(long a)
    {
        return (float) (a + a);
    }

}
