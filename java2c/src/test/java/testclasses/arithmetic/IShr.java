package testclasses.arithmetic; //when changing this, remember to change also the variable in it.se.obfuscator.helpers

import it.se.obfuscator.Obfuscate;

public class IShr
{
    public IShr()
    {

    }

    @Obfuscate
    public int exec(int a, int b)
    {
        return a >> b;
    }

}