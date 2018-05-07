package testclasses.invoke.invokevirtual;

import eu.fbk.hardening.annotation.Obfuscation;

public class InvokeVirtualNoInput
{
    public InvokeVirtualNoInput()
    {

    }

    @Obfuscation
    public boolean add(int a, int b)
    {
        return alwaysTrue();
    }

    public boolean alwaysTrue()
    {
        return true;
    }
}