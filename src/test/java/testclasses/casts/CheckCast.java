package testclasses.casts;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class CheckCast
{
    public CheckCast()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public static String castString(Object a)
    {
        return (String) a;
    }
}
