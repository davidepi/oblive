package testclasses.casts; //when changing this, remember to change also the variable in it.se.obfuscator.helpers

import it.se.obfuscator.Obfuscate;

public class CastInt2Char
{
    public CastInt2Char()
    {

    }

    @Obfuscate
    public char exec(int a)
    {
        return (char)(a+a);
    }

}
