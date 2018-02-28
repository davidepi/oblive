package testclasses.invoke.invokevirtual;

import it.se.obfuscator.Obfuscate;

public class InvokeVirtualFloat
{
    public InvokeVirtualFloat()
    {

    }

    @Obfuscate
    public float add(float a, float b)
    {
        return normalAdd(a,b);
    }
    public float normalAdd(float a, float b)
    {
        return a + b;
    }
}