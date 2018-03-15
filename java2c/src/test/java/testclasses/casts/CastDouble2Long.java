package testclasses.casts; //when changing this, remember to change also the variable in it.se.obfuscator.helpers

import it.se.obfuscator.Obfuscate;

public class CastDouble2Long
{
    public CastDouble2Long()
    {

    }

    @Obfuscate
    public long exec(double a)
    {
        return (long)(a+a);
    }

}
