package testclasses.casts; //when changing this, remember to change also the variable in it.se.obfuscator.helpers

import it.se.obfuscator.Obfuscate;

public class CastLong2Int
{
    public CastLong2Int()
    {

    }

    @Obfuscate
    public int exec(long a)
    {
        return (int)(a+a);
    }

}
