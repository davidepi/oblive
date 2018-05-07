package testclasses.invoke.invokevirtual;

import eu.fbk.hardening.annotation.Obfuscation;

public class InvokeVirtualInt
{
    public InvokeVirtualInt()
    {

    }

    @Obfuscation
    public int add(int a, int b)
    {
        return normalAdd(a,b);
    }

    public int normalAdd(int a, int b)
    {
        return a + b;
    }
}