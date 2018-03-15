package testclasses.conditionals;

import it.se.obfuscator.Obfuscate;

public class LookupswitchNoDefault
{
    public LookupswitchNoDefault()
    {

    }

    @Obfuscate
    public int exec(int a)
    {
        int retval = 500000000;
        switch(a)
        {
            case -5000: retval=-1;break;
            case 17: retval=2;break;
            case 1: retval=3;break;
            case 1000000:
            case 3:
            case -200:retval = 4;break;
        }
        return retval;
    }

}
