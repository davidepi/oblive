package testclasses.casts;

import eu.fbk.hardening.annotation.Obfuscation;

public class CheckCast
{
    public CheckCast()
    {

    }

    @Obfuscation
    public static String castString(Object a)
    {
        return (String)a;
    }
}
