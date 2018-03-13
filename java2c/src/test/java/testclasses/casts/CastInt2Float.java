package testclasses.casts; //when changing this, remember to change also the variable in it.se.obfuscator.helpers

import it.se.obfuscator.Obfuscate;

public class CastInt2Float
{
    public CastInt2Float()
    {

    }

    @Obfuscate
    public float exec(int a)
    {
        return (float)(a+a);
    }

}
