package testclasses.conditionals;

import it.se.obfuscator.Obfuscate;

public class Ificmplt
{
    public Ificmplt()
    {

    }

    @Obfuscate
    public boolean exec(int value)
    {
        if(value >= 1000000000)
            return true;
        return false;
    }

}
