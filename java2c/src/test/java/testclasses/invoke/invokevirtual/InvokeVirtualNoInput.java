package testclasses.invoke.invokevirtual;

import it.se.obfuscator.Obfuscate;

public class InvokeVirtualNoInput
{
    public InvokeVirtualNoInput()
    {

    }

    @Obfuscate
    public boolean add(int a, int b)
    {
        return alwaysTrue();
    }

    public boolean alwaysTrue()
    {
        return true;
    }
}