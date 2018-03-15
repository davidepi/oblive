package testclasses.casts; //when changing this, remember to change also the variable in it.se.obfuscator.helpers

import it.se.obfuscator.Obfuscate;

public class CastDouble2Int
{
    public CastDouble2Int()
    {

    }

    @Obfuscate
    public int exec(double a)
    {
        return (int)(a+a);
    }

}
