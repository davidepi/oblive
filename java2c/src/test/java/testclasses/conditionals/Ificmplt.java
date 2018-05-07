package testclasses.conditionals;

import eu.fbk.hardening.annotation.Obfuscation;

public class Ificmplt
{
    public Ificmplt()
    {

    }

    @Obfuscation
    public boolean exec(int value)
    {
        if(value >= 1000000000)
            return true;
        return false;
    }

}
