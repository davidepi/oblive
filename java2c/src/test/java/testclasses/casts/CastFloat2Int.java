package testclasses.casts; //when changing this, remember to change also the variable in it.se.obfuscator.helpers

import it.se.obfuscator.Obfuscate;

public class CastFloat2Int
{
    public CastFloat2Int()
    {

    }

    @Obfuscate
    public int exec(float a)
    {
        return (int)(a+a);
    }

}
