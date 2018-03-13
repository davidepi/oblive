package testclasses.casts; //when changing this, remember to change also the variable in it.se.obfuscator.helpers

import it.se.obfuscator.Obfuscate;

public class CastInt2Long
{
    public CastInt2Long()
    {

    }

    @Obfuscate
    public long exec(int a)
    {
        return (long)(a+a);
    }

}
