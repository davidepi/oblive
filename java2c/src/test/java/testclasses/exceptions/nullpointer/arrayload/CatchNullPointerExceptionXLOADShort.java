package testclasses.exceptions.nullpointer.arrayload;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassShort;

public class CatchNullPointerExceptionXLOADShort
{

    public CatchNullPointerExceptionXLOADShort()
    {

    }

    @Obfuscate
    public int exec(SupportClassShort obj)
    {
        int res = 0;
        try
        {
            return obj.b[1];
        }
        catch (NullPointerException e)
        {
            res++;
        }

        try
        {
            return obj.b[1];
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            return obj.b[1];
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            return obj.b[1];
        }
        catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
