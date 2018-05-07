package testclasses.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;

public class InvokeStaticFloat
{
    public InvokeStaticFloat()
    {

    }

    @Obfuscation
    public float add(float a, float b)
    {
        return normalAdd(a,b);
    }
    public static float normalAdd(float a, float b)
    {
        return a + b;
    }
}