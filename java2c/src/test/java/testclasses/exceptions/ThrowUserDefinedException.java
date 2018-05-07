package testclasses.exceptions;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowUserDefinedException
{
    public ThrowUserDefinedException()
    {

    }

    @Obfuscation
    public int exec() throws UserDefinedException
    {
        throw new UserDefinedException();
    }
}
