package testclasses.arithmetic; //when changing this, remember to change also the variable in it.se.obfuscator.helpers

import it.se.obfuscator.Obfuscate;

public class IInc
{
    public IInc()
    {

    }

    @Obfuscate
    public int exec(int a)
    {
        a++;
        a--;
        a+=10;
        a-=20;
        return a;
    }

}
