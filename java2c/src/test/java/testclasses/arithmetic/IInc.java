package testclasses.arithmetic; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotation.Obfuscation;

public class IInc
{
    public IInc()
    {

    }

    @Obfuscation
    public int exec(int a)
    {
        a++;
        a--;
        a+=10;
        a-=20;
        return a;
    }

}
