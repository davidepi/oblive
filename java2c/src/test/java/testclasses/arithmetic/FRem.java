package testclasses.arithmetic; //when changing this, remember to change also the variable in it.se.obfuscator.helpers

import it.se.obfuscator.Obfuscate;

public class FRem
{
    public FRem()
    {

    }

    @Obfuscate
    public float exec(float a, float b)
    {
        return a % b;
    }

}
