package testclasses.arithmetic; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class DMul
{
    public DMul()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public double exec(double a, double b)
    {
        return a * b;
    }

}
