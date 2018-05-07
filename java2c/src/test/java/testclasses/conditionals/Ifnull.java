package testclasses.conditionals;

import eu.fbk.hardening.annotation.Obfuscation;

public class Ifnull
{
    public Ifnull()
    {

    }

    @Obfuscation
    public boolean exec(Object value)
    {
        if(value != null)
            return true;
        return false;
    }

}
