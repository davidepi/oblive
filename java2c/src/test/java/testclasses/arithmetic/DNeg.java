package testclasses.arithmetic; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotation.Obfuscation;

public class DNeg
{
    public DNeg()
    {

    }

    @Obfuscation
    public double exec(double a)
    {
        return -a;
    }

}
