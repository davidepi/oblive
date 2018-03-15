package testclasses.conditionals;

import it.se.obfuscator.Obfuscate;

public class Ificmpge
{
    public Ificmpge()
    {

    }

    @Obfuscate
    public boolean exec(int value)
    {
        if(value < 1000000000)
            return true;
        return false;
    }

}
