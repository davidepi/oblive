package testclasses;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class CollidingString
{
    public CollidingString()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public static String exec()
    {
        String a = "a";
        String b = "a";
        String c = "a";
        String d = "longer";
        String e = "longest";
        String f = "longer";
        return a+b+c+d+e+f;
    }
}
