package testclasses.arithmetic; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotation.Obfuscation;

public class DMul
{
    public DMul()
    {

    }

    @Obfuscation
    public double exec(double a, double b)
    {
        return a * b;
    }

}
