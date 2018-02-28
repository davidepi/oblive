package testclasses.invoke.invokestatic;

import it.se.obfuscator.Obfuscate;

public class InvokeStaticVoid
{
    public InvokeStaticVoid()
    {

    }

    @Obfuscate
    public void add(int a, int b)
    {
        print(a,b);
    }

    public static void print(int a, int b)
    {
        System.out.println(a+b);
    }
}