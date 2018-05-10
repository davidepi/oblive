package testclasses.stack;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class FLoad
{
    public FLoad()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public float exec(float a)
    {
        return a;
    }
}
