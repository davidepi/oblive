package testclasses.casts;

import it.se.obfuscator.Obfuscate;

public class CheckCast
{
    public CheckCast()
    {

    }

    @Obfuscate
    public static String castString(Object a)
    {
        return (String)a;
    }
}
