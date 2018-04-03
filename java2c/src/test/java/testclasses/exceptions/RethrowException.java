package testclasses.exceptions;

import it.se.obfuscator.Obfuscate;

public class RethrowException
{
    public RethrowException()
    {

    }

    @Obfuscate
    public int exec()
    {
        int res = 0;
        try
        {
            throw new ClassCastException();
        }
        catch(ClassCastException e)
        {
            throw new ClassCastException();
        }
    }
}
