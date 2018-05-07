package testclasses.exceptions.nullpointer;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowNullException
{
    public ThrowNullException()
    {

    }

    @Obfuscation
    public int exec()
    {
        throw null;
    }
}
