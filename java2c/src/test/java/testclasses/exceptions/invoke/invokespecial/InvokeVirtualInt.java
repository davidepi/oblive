package testclasses.exceptions.invoke.invokespecial;

import it.se.obfuscator.Obfuscate;

public class InvokeVirtualInt
{
    public InvokeVirtualInt()
    {

    }

    @Obfuscate
    public int add(int a, int b)
    {
        return normalAdd(a,b);
    }

    public int normalAdd(int a, int b)
    {
        int c = 1/0;
        return a + b;
    }
}