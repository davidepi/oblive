package testclasses.stack;


import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class LdcFloatInfNegative
{
    public LdcFloatInfNegative()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public float exec()
    {
        return Float.NEGATIVE_INFINITY;
    }
}
