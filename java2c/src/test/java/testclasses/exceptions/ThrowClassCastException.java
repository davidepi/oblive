package testclasses.exceptions;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowClassCastException
{
    public ThrowClassCastException()
    {

    }

    @Obfuscation
    public static String castString(Object a)
    {
        return (String)a;
    }
}
