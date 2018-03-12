package testclasses.arithmetic; //when changing this, remember to change also the variable in it.se.obfuscator.helpers

import it.se.obfuscator.Obfuscate;

public class LRem
{
    public LRem()
    {

    }

    @Obfuscate
    public long exec(long a, long b)
    {
        return a % b;
    }

}
