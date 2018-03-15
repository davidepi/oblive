package testclasses.conditionals;

import it.se.obfuscator.Obfuscate;

public class Ifnonnull
{
    public Ifnonnull()
    {

    }

    @Obfuscate
    public boolean exec(Object value)
    {
        if(value == null)
            return true;
        return false;
    }

}
