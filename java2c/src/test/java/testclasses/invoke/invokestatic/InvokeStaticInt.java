package testclasses.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;

public class InvokeStaticInt
{
    public InvokeStaticInt()
    {

    }

    @Obfuscation
    public int add(int a, int b)
    {
        return testclasses.invoke.invokestatic.InvokeStaticInt.normalAdd(a,b);
    }

    public static int normalAdd(int a, int b)
    {
        return a + b;
    }
}