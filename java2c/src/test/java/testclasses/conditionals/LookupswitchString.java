package testclasses.conditionals;

import it.se.obfuscator.Obfuscate;

public class LookupswitchString
{
    public LookupswitchString()
    {

    }

    @Obfuscate
    public int exec(String a)
    {
        int retval;
        switch(a)
        {
            case "hello": retval=-1;break;
            case "world": retval=2;break;
            case "ciao": retval=3;break;
            case "mondo":
            case "お早う":
            case "世界":retval = 4;break;
            default:retval = 5;
        }
        return retval;
    }

}
