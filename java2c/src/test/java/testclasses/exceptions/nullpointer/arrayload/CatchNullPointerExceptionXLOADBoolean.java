package testclasses.exceptions.nullpointer.arrayload;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassBoolean;

public class CatchNullPointerExceptionXLOADBoolean
{

    public CatchNullPointerExceptionXLOADBoolean()
    {

    }

    @Obfuscate
    public int exec(SupportClassBoolean obj)
    {
        int res = 0;
        try
        {
            return obj.b[1]?1:0;
        }
        catch (NullPointerException e)
        {
            res++;
        }

        try
        {
            return obj.b[1]?1:0;
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            return obj.b[1]?1:0;
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            return obj.b[1]?1:0;
        }
        catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
