package testclasses.casts; //when changing this, remember to change also the variable in it.se.obfuscator.helpers

import it.se.obfuscator.Obfuscate;

public class CastLong2Float
{
    public CastLong2Float()
    {

    }

    @Obfuscate
    public float exec(long a)
    {
        return (float)(a+a);
    }

}
