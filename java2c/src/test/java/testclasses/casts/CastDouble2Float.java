package testclasses.casts; //when changing this, remember to change also the variable in it.se.obfuscator.helpers

import it.se.obfuscator.Obfuscate;

public class CastDouble2Float
{
    public CastDouble2Float()
    {

    }

    @Obfuscate
    public float exec(double a)
    {
        return (float)(a+a);
    }

}
