package testclasses.casts; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotation.Obfuscation;

public class CastInt2Short
{
    public CastInt2Short()
    {

    }

    @Obfuscation
    public short exec(int a)
    {
        return (short)(a+a);
    }

}
