package testclasses.arithmetic; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotation.Obfuscation;

public class LDiv
{
    public LDiv()
    {

    }

    @Obfuscation
    public long exec(long a, long b)
    {
        return a / b;
    }

}
