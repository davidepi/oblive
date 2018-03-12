package testclasses.conditionals;

import it.se.obfuscator.Obfuscate;

public class Ifacmpne
{
    public Ifacmpne()
    {

    }

    @Obfuscate
    public boolean exec(Object value0, Object value1)
    {
        if(value0==value1)
            return true;
        else
            return false;
    }

}
