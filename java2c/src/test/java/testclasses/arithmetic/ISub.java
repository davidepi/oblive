package testclasses.arithmetic; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotation.Obfuscation;

public class ISub
{
    public ISub()
    {

    }

    @Obfuscation
    public int exec(int a, int b)
    {
        return a - b;
    }

}
