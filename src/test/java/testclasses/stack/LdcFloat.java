package testclasses.stack;


import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class LdcFloat
{
    public LdcFloat()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public float exec()
    {
        float a = 3.5f;
        float b = -0.5f;
        return a + b;
    }
}
