package testclasses.overload;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class OverloadedMethodsBoolean
{
    public OverloadedMethodsBoolean()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public static int add(int a, double b)
    {
        return a + (int)b;
    }

    @Obfuscation(protections =  Protections.TO_NATIVE_CODE)
    public static boolean add(boolean a, boolean b)
    {
        return a&&b;
    }
}
