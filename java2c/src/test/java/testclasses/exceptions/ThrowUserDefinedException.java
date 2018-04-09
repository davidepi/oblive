package testclasses.exceptions;

import it.se.obfuscator.Obfuscate;

public class ThrowUserDefinedException
{
    public ThrowUserDefinedException()
    {

    }

    @Obfuscate
    public int exec() throws UserDefinedException
    {
        throw new UserDefinedException();
    }
}
