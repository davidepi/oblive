package testclasses.exceptions;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowClassCastException
{
    public ThrowClassCastException()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public static String castString(Object a)
    {
        return (String) a;
    }
}
