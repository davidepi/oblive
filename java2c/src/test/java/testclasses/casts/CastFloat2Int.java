package testclasses.casts; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotation.Obfuscation;

public class CastFloat2Int
{
    public CastFloat2Int()
    {

    }

    @Obfuscation
    public int exec(float a)
    {
        return (int)(a+a);
    }

}
