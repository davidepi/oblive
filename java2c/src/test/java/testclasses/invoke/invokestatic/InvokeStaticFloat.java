package testclasses.invoke.invokestatic;

import it.se.obfuscator.Obfuscate;

public class InvokeStaticFloat
{
    public InvokeStaticFloat()
    {

    }

    @Obfuscate
    public float add(float a, float b)
    {
        return normalAdd(a,b);
    }
    public static float normalAdd(float a, float b)
    {
        return a + b;
    }
}