package testclasses.arithmetic; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotation.Obfuscation;

public class LNeg
{
    public LNeg()
    {

    }

    @Obfuscation
    public long exec(long a)
    {
        return -a;
    }

}
