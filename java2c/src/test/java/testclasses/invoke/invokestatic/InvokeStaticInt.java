package testclasses.invoke.invokestatic;

import it.se.obfuscator.Obfuscate;

public class InvokeStaticInt
{
    public InvokeStaticInt()
    {

    }

    @Obfuscate
    public int add(int a, int b)
    {
        return testclasses.invoke.invokestatic.InvokeStaticInt.normalAdd(a,b);
    }

    public static int normalAdd(int a, int b)
    {
        return a + b;
    }
}