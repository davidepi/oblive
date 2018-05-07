package testclasses.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;

public class InvokeStaticVoid
{
    public InvokeStaticVoid()
    {

    }

    @Obfuscation
    public void add(int a, int b)
    {
        print(a,b);
    }

    public static void print(int a, int b)
    {
        System.out.println(a+b);
    }
}