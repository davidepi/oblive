package testclasses.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeStaticFloat
{
    public InvokeStaticFloat()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public float add(float a, float b)
    {
        return normalAdd(a, b);
    }

    public static float normalAdd(float a, float b)
    {
        return a + b;
    }
}