package testclasses.overload;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class OverloadedMethodsArrays
{
    public OverloadedMethodsArrays()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public static int add(int a, double b)
    {
        return a + (int)b;
    }

    @Obfuscation(protections =  Protections.TO_NATIVE_CODE)
    public static String add(String[] a, int[] c)
    {
        return a[0]+Integer.toString(c[0]);
    }
}
