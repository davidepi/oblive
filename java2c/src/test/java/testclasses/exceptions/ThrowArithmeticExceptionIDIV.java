package testclasses.exceptions;

import it.se.obfuscator.Obfuscate;

public class ThrowClassCastException
{
    public ThrowClassCastException()
    {

    }

    @Obfuscate
    public static String castString(Object a)
    {
        return (String)a;
    }
}
