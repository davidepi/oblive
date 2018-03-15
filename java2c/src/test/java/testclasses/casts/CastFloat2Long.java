package testclasses.casts; //when changing this, remember to change also the variable in it.se.obfuscator.helpers

import it.se.obfuscator.Obfuscate;

public class CastFloat2Long
{
    public CastFloat2Long()
    {

    }

    @Obfuscate
    public long exec(float a)
    {
        return (long)(a+a);
    }

}
