package testclasses.arithmetic; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class LUShr
{
    public LUShr()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    //param 2 is always int. It is casted by the compiler otherwise
    public long exec(long a, int b)
    {
        return a >>> b;
    }

}
