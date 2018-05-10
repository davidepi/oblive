package testclasses.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeStaticVoid
{
    public InvokeStaticVoid()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public void add(int a, int b)
    {
        print(a, b);
    }

    public static void print(int a, int b)
    {
        System.out.println(a + b);
    }
}