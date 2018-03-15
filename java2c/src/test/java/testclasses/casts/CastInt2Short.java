package testclasses.casts; //when changing this, remember to change also the variable in it.se.obfuscator.helpers

import it.se.obfuscator.Obfuscate;

public class CastInt2Short
{
    public CastInt2Short()
    {

    }

    @Obfuscate
    public short exec(int a)
    {
        return (short)(a+a);
    }

}
