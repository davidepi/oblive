package testclasses.exceptions.nullpointer;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowNullException
{
    public ThrowNullException()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec()
    {
        throw null;
    }
}
