package testclasses.invoke.invokevirtual;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeVirtualInt
{
    public InvokeVirtualInt()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int add(int a, int b)
    {
        return normalAdd(a, b);
    }

    public int normalAdd(int a, int b)
    {
        return a + b;
    }
}