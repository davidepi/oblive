package testclasses.conditionals;

import eu.fbk.hardening.annotation.Obfuscation;

public class Ifnonnull
{
    public Ifnonnull()
    {

    }

    @Obfuscation
    public boolean exec(Object value)
    {
        if(value == null)
            return true;
        return false;
    }

}
