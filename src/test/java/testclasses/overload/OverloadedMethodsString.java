package testclasses.overload;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class OverloadedMethodsString
{
    public OverloadedMethodsString()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public static int add(int a, double b)
    {
        return a + (int)b;
    }

    @Obfuscation(protections =  Protections.TO_NATIVE_CODE)
    public static String add(String a, String b, int c)
    {
        return a+ Integer.toString(c) +b;
    }
}
