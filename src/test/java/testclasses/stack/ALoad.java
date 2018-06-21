package testclasses.stack;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ALoad
{
    public ALoad()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public String exec(String a)
    {
        return a;
    }
}
