package testclasses.arithmetic; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotation.Obfuscation;

public class FNeg
{
    public FNeg()
    {

    }

    @Obfuscation
    public float exec(float a)
    {
        return -a;
    }

}
