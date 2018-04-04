package testclasses.exceptions.nullpointer;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.UserDefinedException;

public class CatchThrowedNullException
{
    public CatchThrowedNullException()
    {

    }

    @Obfuscate
    public int exec()
    {
        int res = 0;
        try
        {
            throw null;
        }
        catch (NullPointerException e)
        {
            res++;
        }

        try
        {
            throw null;
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            throw null;
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            throw null;
        }
        catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
