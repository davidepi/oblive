package testclasses.arithmetic; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class LNeg
{
    public LNeg()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public long exec(long a)
    {
        return -a;
    }

}
