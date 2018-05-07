package testclasses.invoke.invokespecial;

import eu.fbk.hardening.annotation.Obfuscation;

public class InvokeVirtualFloat
{
    public InvokeVirtualFloat()
    {

    }

    @Obfuscation
    public float add(float a, float b)
    {
        return normalAdd(a,b);
    }
    public float normalAdd(float a, float b)
    {
        return a + b;
    }
}