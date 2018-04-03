package testclasses.exceptions.nullpointer.arraystore;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassInt;

public class CatchNullPointerExceptionXSTOREInt
{

    public CatchNullPointerExceptionXSTOREInt()
    {

    }

    @Obfuscate
    public int exec(SupportClassInt obj)
    {
        int res = 0;
        try
        {
            obj.b[1] = 1;
        }
        catch (NullPointerException e)
        {
            res++;
        }

        try
        {
            obj.b[1] = 0;
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            obj.b[1] = 1;
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            obj.b[1] = 0;
        }
        catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
