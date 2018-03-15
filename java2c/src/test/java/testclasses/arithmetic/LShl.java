package testclasses.arithmetic; //when changing this, remember to change also the variable in it.se.obfuscator.helpers

import it.se.obfuscator.Obfuscate;

public class LShl
{
    public LShl()
    {

    }

    @Obfuscate
    //param 2 is always int. It is casted by the compiler otherwise
    public long exec(long a, int b)
    {
        return a << b;
    }

}
