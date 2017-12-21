package testclasses;

import it.se.obfuscator.Obfuscate;

public class AdderInvokeMethodFloat
{
    public AdderInvokeMethodFloat()
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