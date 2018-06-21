package testclasses.stack;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class LLoad
{
    public LLoad()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public long exec(long a)
    {
        return a;
    }
}
