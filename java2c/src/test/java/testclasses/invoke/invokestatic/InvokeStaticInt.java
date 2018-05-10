package testclasses.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeStaticInt
{
    public InvokeStaticInt()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int add(int a, int b)
    {
        return testclasses.invoke.invokestatic.InvokeStaticInt.normalAdd(a, b);
    }

    public static int normalAdd(int a, int b)
    {
        return a + b;
    }
}