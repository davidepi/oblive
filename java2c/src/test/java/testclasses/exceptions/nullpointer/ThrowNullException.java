package testclasses.exceptions.nullpointer;

import it.se.obfuscator.Obfuscate;

public class ThrowNullException
{
    public ThrowNullException()
    {

    }

    @Obfuscate
    public int exec()
    {
        throw null;
    }
}
