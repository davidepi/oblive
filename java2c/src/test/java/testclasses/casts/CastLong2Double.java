package testclasses.casts; //when changing this, remember to change also the variable in it.se.obfuscator.helpers

import it.se.obfuscator.Obfuscate;

public class CastLong2Double
{
    public CastLong2Double()
    {

    }

    @Obfuscate
    public double exec(long a)
    {
        return (double)(a+a);
    }

}
