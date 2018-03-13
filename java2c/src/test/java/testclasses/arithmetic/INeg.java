package testclasses.arithmetic; //when changing this, remember to change also the variable in it.se.obfuscator.helpers

import it.se.obfuscator.Obfuscate;

public class INeg
{
    public INeg()
    {

    }

    @Obfuscate
    public int exec(int a)
    {
        return -a;
    }

}
