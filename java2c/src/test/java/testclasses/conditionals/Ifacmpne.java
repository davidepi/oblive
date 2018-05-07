package testclasses.conditionals;

import eu.fbk.hardening.annotation.Obfuscation;

public class Ifacmpne
{
    public Ifacmpne()
    {

    }

    @Obfuscation
    public boolean exec(Object value0, Object value1)
    {
        if(value0==value1)
            return true;
        else
            return false;
    }

}
