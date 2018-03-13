package testclasses.arithmetic; //when changing this, remember to change also the variable in it.se.obfuscator.helpers

import it.se.obfuscator.Obfuscate;

public class LNeg
{
    public LNeg()
    {

    }

    @Obfuscate
    public long exec(long a)
    {
        return -a;
    }

}
