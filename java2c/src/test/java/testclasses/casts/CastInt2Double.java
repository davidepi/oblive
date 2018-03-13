package testclasses.casts; //when changing this, remember to change also the variable in it.se.obfuscator.helpers

import it.se.obfuscator.Obfuscate;

public class CastInt2Double
{
    public CastInt2Double()
    {

    }

    @Obfuscate
    public double exec(int a)
    {
        return (double)(a+a);
    }

}
